/**
 * 
 */
package com.wk.access.server.connection;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;

/**
 * @author jiansun
 *
 */
public class Service {
	protected static Logger logger = LoggerFactory.getLogger(Service.class);

	protected int port;	

	protected ChannelInitializer<Channel> channelInitializer;
	protected Channel channel;
	
	/**
	 * @param port the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	}
	
	/**
	 * @param channelInitializer the channelInitializer to set
	 */
	public void setChannelInitializer(ChannelInitializer<Channel> channelInitializer) {
		this.channelInitializer = channelInitializer;
	}

	/**
	 * 
	 */
	public void start() {
		Thread thread = new Thread( ){
        	public void run(){
                logger.info("Listen station connection with thread on port:" + port);
                try {
                	// 用来接收进来的连接
                    EventLoopGroup parentGroup = new NioEventLoopGroup();
                    
                    // 用来处理已经被接收的连接
                    EventLoopGroup childGroup = new NioEventLoopGroup();

                    try{
                    	// ServerBootstrap 是一个启动 NIO 服务的辅助启动类
                        ServerBootstrap bootstrap = new ServerBootstrap();
                        
                        // 设置EventLoopGroup事件循环组
                        bootstrap.group(parentGroup, childGroup);
                        
                        // 设置通道类型
                        bootstrap.channel(NioServerSocketChannel.class);
                        
                        // 设置本地地址，也可以通过bind(...)或connect(...)
                        bootstrap.localAddress(new InetSocketAddress(port));
                        
                        // 设置子ChannelHandler
                        bootstrap.childHandler(channelInitializer);
                        
                        // 设置通道选项,是提供给NioServerSocketChannel 用来接收进来的连接
                        bootstrap.option(ChannelOption.SO_BACKLOG, 128);
                        
                        // 设置子通道选项
                        bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
                        
                        // 绑定端口
                        ChannelFuture f = bootstrap.bind().sync();
                        channel = f.channel();
                        
                        // 等待服务端监听端口关闭
                        channel.closeFuture().sync();
                    } finally {                    	
                    	// 释放线程池资源,优雅的退出
                        childGroup.shutdownGracefully();
                        parentGroup.shutdownGracefully();
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}       		
        	}
        };
        
        thread.start();
    }
	
	/**
	 * 
	 */
	public void stop() {
		if(this.channel != null) {
			this.channel.close();
		}
	}
}
