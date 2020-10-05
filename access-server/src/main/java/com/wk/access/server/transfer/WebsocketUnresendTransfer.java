package com.wk.access.server.transfer;

import com.hcharger.exception.ErrorcodeException;
import com.hcharger.hhd.protocol.codec.VarintCodec;
import com.hcharger.hhd.protocol.message.Message;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author jiansun
 *
 */
public class WebsocketUnresendTransfer implements ITransfer {
	
	static Logger logger = LoggerFactory.getLogger(WebsocketUnresendTransfer.class);
	
	protected Channel channel;
	
	/*
	 * 
	 */
	public WebsocketUnresendTransfer(Channel ch) {
		super();
		this.channel = ch;
	}

	/*
	 * (non-Javadoc)
	 * @see com.hcharger.server.transfer.ITransfer#transfer(com.hcharger.protocol.codec.ICodec)
	 */
	public void transfer(Message message) {
		try {
			int max = VarintCodec.size(message);
			ByteBuf buf = channel.alloc().buffer(max);
			
			VarintCodec.encode(message, message.code(), buf);
			
			//发送信息
			channel.writeAndFlush(new BinaryWebSocketFrame(buf));
		} catch (ErrorcodeException e) {
			e.printStackTrace();
		}
		
	}

}
