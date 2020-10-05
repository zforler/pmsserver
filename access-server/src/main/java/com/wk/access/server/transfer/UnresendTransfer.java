package com.wk.access.server.transfer;


import com.wk.access.message.Message;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;


public class UnresendTransfer implements ITransfer {
	
	static Logger logger = LoggerFactory.getLogger(UnresendTransfer.class);
	public static final AtomicInteger i = new AtomicInteger(0);
	public static final int getIndex() {
		int current;
		int next;
		do {
			current = i.get();
			next = current >= 2147483647 ? 0 : current + 1;
		} while(!i.compareAndSet(current, next));

		return next;
	}
	public final int incrementAndGet() {
		int current;
		int next;
		do {
			current = i.get();
			next = current >= 2147483647 ? 0 : current + 1;
		} while(!i.compareAndSet(current, next));

		return next;
	}

	public final int decrementAndGet() {
		int current;
		int next;
		do {
			current = i.get();
			next = current <= 0?2147483647:current - 1;
		} while(!i.compareAndSet(current, next));

		return next;
	}

	protected Channel channel;
	
	public UnresendTransfer(Channel channel) {
		super();
		this.channel = channel;
	}

	@Override
	public void transfer(Message message) {
		try {
			ByteBuf buf = channel.alloc().buffer(message.size());
			message.encode( buf);
			
			channel.writeAndFlush(buf);
		} catch (Exception e) {
			logger.error("transfer error:"+e.getMessage(),e);
		}		
	}
}
