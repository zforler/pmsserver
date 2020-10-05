/**
 * 
 */
package com.wk.access.handler;

import io.netty.channel.ChannelHandler;

public interface IMessageHandlerFactory {
	ChannelHandler createHandler();
}
