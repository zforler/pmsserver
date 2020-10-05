/**
 * 
 */
package com.wk.access.server.transfer;

import io.netty.channel.Channel;

/**
 * @author jiansun
 *
 */
public class UnresendTransferFactory implements ITransferFactory {
	
	/*
	 * (non-Javadoc)
	 * @see com.hcharger.server.transfer.ITransferFactory#createTransfer(io.netty.channel.ChannelHandlerContext)
	 */
	public ITransfer createTransfer(Channel channel) {
		return new UnresendTransfer(channel);
	}
	
}
