package com.wk.access.handler;

import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author qiusichuang
 *
 */
public class ReaderShowDataHandlerFactory implements IMessageHandlerFactory {
	@Override
	public SimpleChannelInboundHandler<?> createHandler() {
		return new ReaderShowDataHandler();
	}

}
