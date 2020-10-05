package com.wk.access.config;

import com.wk.access.handler.IMessageHandlerFactory;
import com.wk.access.handler.ReaderShowDataHandlerFactory;
import com.wk.access.handler.WriterShowDataHandlerFactory;
import com.wk.access.server.connection.DeviceServer;
import com.wk.access.server.connection.Service;
import com.wk.access.server.connection.SimpleChannelInitializer;
import com.wk.access.server.transfer.ISslContextFactory;
import com.wk.access.server.transfer.ITransferFactory;
import com.wk.access.server.transfer.SslContextFactory;
import com.wk.access.server.transfer.UnresendTransferFactory;
import com.wk.access.util.HandlerExecutor;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Config {
    @Value("${handler.pool.coreSize:8}")
    private int corePoolSize;
    @Value("${handler.pool.maxSize:1000}")
    private int maxPoolSize;
    @Value("${handler.pool.keepAlive:8}")
    private long keepAlive;
    //设备心跳消息时间间隔
    @Value("${device.reader.idle.timeout:90}")
    private int readerIdleTimeout; //读空闲时间，发心跳
    @Value("${device.writer.idle.timeout:30}")
    private int writerIdleTimeout; //写空闲时间，发心跳

    @Bean
    public ReaderShowDataHandlerFactory readerShowDataHandlerFactory(){
        return  new ReaderShowDataHandlerFactory();
    }
    @Bean
    public WriterShowDataHandlerFactory writerShowDataHandlerFactory(){
        return  new WriterShowDataHandlerFactory();
    }



    //ssl device监听端口号
    @Value("${server.device.ssl.port:9001}")
    private int deviceSslServerPort;
    //nossl device监听端口号
    @Value("${server.device.nossl.port:9002}")
    private int deviceNoSslServerPort;
    //SSL秘钥参数
    @Value("${spring.server.ssl.keystore}")
    private String sslKeystore;
    @Value("${spring.server.ssl.password}")
    private String sslPassword;

    /**
     *注入无ssl的设备service
     * @return
     */
    @Bean
    public Service deviceNoSslService(){
        Service deviceService=new Service();
        //handler列表
        deviceService.setChannelInitializer(deviceNoSslServiceInitializer());
        //无ssl端口号
        deviceService.setPort(deviceNoSslServerPort);
        return deviceService;
    }
    /**
     *注入无ssl的设备service
     * @return
     */
//    @Bean
//    public Service deviceSslService(){
//        Service deviceService=new Service();
//        //handler列表
//        deviceService.setChannelInitializer(deviceSslServiceInitializer());
//        //有ssl端口号
//        deviceService.setPort(deviceSslServerPort);
//        return deviceService;
//    }

    /**
     * 无Ssl service handler列表
     * @return
     */
    @Bean
    public ChannelInitializer<Channel> deviceNoSslServiceInitializer(){
        SimpleChannelInitializer channelInitializer= new SimpleChannelInitializer();
        channelInitializer.setReaderIdleTimeout(readerIdleTimeout);
        channelInitializer.setWriterIdleTimeout(writerIdleTimeout);
        List<IMessageHandlerFactory> messageHandlerFactories=new ArrayList<>();
        messageHandlerFactories.add(new WriterShowDataHandlerFactory());
        messageHandlerFactories.add(new ReaderShowDataHandlerFactory());

        channelInitializer.setMessageHandlerFactories(messageHandlerFactories);

        return channelInitializer;
    }

    /**
     * 有Ssl service handler列表
     * @return
     */
//    @Bean
//    public ChannelInitializer<Channel> deviceSslServiceInitializer(){
//        SimpleChannelInitializer channelInitializer= new SimpleChannelInitializer();
//        channelInitializer.setSslContextFactory(sslContextFactory());
//        channelInitializer.setReaderIdleTimeout(readerIdleTimeout);
//        channelInitializer.setWriterIdleTimeout(writerIdleTimeout);
//        List<IMessageHandlerFactory> messageHandlerFactories=new ArrayList<IMessageHandlerFactory>();
//        messageHandlerFactories.add(writerFactory());
//        messageHandlerFactories.add(readerFactory());
//
//        channelInitializer.setMessageHandlerFactories(messageHandlerFactories);
//
//        return channelInitializer;
//    }

    /**
     * sslContext工厂
     * @return
     */
    @Bean
    public ISslContextFactory sslContextFactory(){
        SslContextFactory sslContextFactory = new SslContextFactory();
        sslContextFactory.setJksPath(sslKeystore);
        sslContextFactory.setPassword(sslPassword);
        return sslContextFactory;
    }

    @Bean
    public DeviceServer deviceServer(){
        DeviceServer deviceServer=new DeviceServer();
        deviceServer.setDeviceNoSslService(deviceNoSslService());
//        deviceServer.setDeviceSslService(deviceSslService());
        return deviceServer;
    }
    @Bean
    public HandlerExecutor executor(){
        return new HandlerExecutor(corePoolSize,maxPoolSize,keepAlive);
    }
}
