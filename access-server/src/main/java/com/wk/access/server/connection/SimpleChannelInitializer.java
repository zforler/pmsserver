/**
 * 
 */
package com.wk.access.server.connection;


import com.wk.access.handler.IMessageHandlerFactory;
import com.wk.access.server.transfer.ISslContextFactory;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslHandler;
import io.netty.handler.timeout.IdleStateHandler;

import javax.net.ssl.SSLEngine;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author jiansun
 *
 */
public class SimpleChannelInitializer extends ChannelInitializer<Channel> {
	protected int readerIdleTimeout;
	protected int writerIdleTimeout;

	protected ISslContextFactory sslContextFactory = null;
	protected List<IMessageHandlerFactory> messageHandlerFactories;


	/**
	 * @param readerIdleTimeout the readerIdleTimeout to set
	 */
	public void setReaderIdleTimeout(int readerIdleTimeout) {
		this.readerIdleTimeout = readerIdleTimeout;
	}

	/**
	 * @param writerIdleTimeout the writerIdleTimeout to set
	 */
	public void setWriterIdleTimeout(int writerIdleTimeout) {
		this.writerIdleTimeout = writerIdleTimeout;
	}

	/**
	 * @param sslContextFactory the sslContextFactory to set
	 */
	public void setSslContextFactory(ISslContextFactory sslContextFactory) {
		this.sslContextFactory = sslContextFactory;
	}

	/**
	 * @param messageHandlerFactories the messageHandlerFactories to set
	 */
	public void setMessageHandlerFactories(List<IMessageHandlerFactory> messageHandlerFactories) {
		this.messageHandlerFactories = messageHandlerFactories;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.netty.channel.ChannelInitializer#initChannel(io.netty.channel.Channel)
	 */
	@Override
	protected void initChannel(Channel channel) throws Exception {
		ChannelPipeline pipeline = channel.pipeline();
		// SSL
		if (this.sslContextFactory != null) {
			SslContext context = this.sslContextFactory.getSslContext();

			SSLEngine engine = context.newEngine(channel.alloc());
			engine.setUseClientMode(false);
			pipeline.addLast(new SslHandler(engine));
		}
		
		// 心跳
		pipeline.addLast(new IdleStateHandler(this.readerIdleTimeout, this.writerIdleTimeout, 0, TimeUnit.SECONDS));

		// 后续处理类
		for (IMessageHandlerFactory factory : this.messageHandlerFactories) {
			ChannelHandler handler = factory.createHandler();
			pipeline.addLast(handler);
		}
	}
}
