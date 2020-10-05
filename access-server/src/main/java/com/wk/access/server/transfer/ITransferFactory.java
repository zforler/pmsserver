package com.wk.access.server.transfer;

import io.netty.channel.Channel;

public interface ITransferFactory {
	ITransfer createTransfer(Channel channel);
}
