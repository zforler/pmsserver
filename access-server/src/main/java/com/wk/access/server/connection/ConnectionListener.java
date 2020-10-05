/**
 * 
 */
package com.wk.access.server.connection;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.EventLoop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author jiansun
 *
 */
public class ConnectionListener implements ChannelFutureListener {
	protected static Logger logger = LoggerFactory.getLogger(ConnectionListener.class);

	protected Connector connector;

	public ConnectionListener(Connector client) {
		this.connector = client;
	}

	/*
	 * (non-Javadoc)
	 * @see io.netty.util.concurrent.GenericFutureListener#operationComplete(io.netty.util.concurrent.Future)
	 */
	public void operationComplete(ChannelFuture future) throws Exception {
		if (!future.isSuccess()) {
			if(!connector.isRetry() || !connector.getChargerClient().isOnline()){
				logger.warn("charger is offline:" + connector.getId());
				return;
			}
			logger.info("Connect to server failed, will reconnect 10s later.");

			final EventLoop loop = future.channel().eventLoop();
			loop.schedule(new Runnable() {
				public void run() {
					connector.createBootstrap(new Bootstrap(), loop);
				}
			}, 10L, TimeUnit.SECONDS);
		} else {
			connector.connected(future.channel());
		}
	}
}
