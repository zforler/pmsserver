
package com.wk.access.server.connection;

import com.wk.access.client.EquipmentClient;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class Connector extends Client {
	protected static final Logger logger = LoggerFactory.getLogger(Connector.class);
	
	protected String host;
	protected int port;

	protected EventLoopGroup loop;
	protected volatile boolean retry;
	protected int retryTime=30000;

	protected ChannelInitializer<Channel> channelInitializer;
	protected volatile boolean connected;
	private EquipmentClient equipmentClient;
	public boolean isRetry() {
		return retry;
	}

	public void setRetry(boolean retry) {
		this.retry = retry;
	}

	public int getRetryTime() {
		return retryTime;
	}

	public void setRetryTime(int retryTime) {
		this.retryTime = retryTime;
	}

	public EquipmentClient getChargerClient() {
		return equipmentClient;
	}

	public void setChargerClient(EquipmentClient equipmentClient) {
		this.equipmentClient = equipmentClient;
	}
	/**
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}
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
	 * @return the connected
	 */
	public boolean isConnected() {
		return connected;
	}
	/**
	 * 
	 * @param bootstrap
	 * @param eventLoop
	 * @return
	 */
	public Bootstrap createBootstrap(Bootstrap bootstrap, EventLoopGroup eventLoop) {
		if(bootstrap != null) {
			bootstrap.group(eventLoop)
			  		 .channel(NioSocketChannel.class)
			  		 .option(ChannelOption.TCP_NODELAY, true)
			  		 .option(ChannelOption.SO_KEEPALIVE, true)
					 .handler(channelInitializer);

			// 发起异步链接操作
			logger.info(id + ":" +"connect to " + host + ":" + port + " ......");
			bootstrap.connect(host, port).addListener(new ConnectionListener(this));
		}
		
		return bootstrap;
	}
	
	/**
	 * 
	 */
	public void start() {		
		loop = new NioEventLoopGroup();
		retry=true;
		createBootstrap(new Bootstrap(), loop);
	}
	
	/**
	 * 
	 */
	protected void connected(Channel channel) {
		this.channel = channel;
//		this.transfer = new UnresendTransfer(channel);
		this.transfer = transferFactory.createTransfer(channel);
		channel.attr(Client.ATTR).set(this);
		
		this.connected = true;
	}

	@Override
	public void disconnected(Channel ch) {
		this.connected = false;
		super.disconnected(ch);
		logger.warn("connector disconnected");
//		logger.info("disconnected retry:"+retry);
//		if(retry){
//			timer.schedule(new TimerTask(){
//				public void run(){
//					if(equipmentClient.isOnline()){
//						loop = new NioEventLoopGroup();
//						createBootstrap(new Bootstrap(), loop);
//						this.cancel();
//					}else{
//						logger.warn("chargerClient is offline"+id);
//					}
//				}
//				},retryTime);
//
//		}
//
	}
}
