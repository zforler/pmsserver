package com.wk.access.handler;

import io.netty.channel.ChannelHandler;

public class WriterShowDataHandlerFactory implements IMessageHandlerFactory {

	public ChannelHandler createHandler() {
		return new WriterShowDataHandler();
	}

}
