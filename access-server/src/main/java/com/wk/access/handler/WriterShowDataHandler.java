package com.wk.access.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**将发送的信息打印到日志中。
 * @author ssc
 *
 */
public class WriterShowDataHandler extends ChannelOutboundHandlerAdapter {
	protected static Logger logger = LoggerFactory.getLogger(WriterShowDataHandler.class);

	@Override
	public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
		if(msg instanceof ByteBuf) {
			ByteBuf buf = (ByteBuf)msg;
			//输出发送的消息到日志中
			StringBuilder buffer = new StringBuilder("send to:" + ctx.channel().remoteAddress() + ", length:");
			buffer.append(buf.readableBytes()).append(" data:");
			buffer.append(ByteBufUtil.hexDump(buf));
			
			logger.info(buffer.toString());
		}
		
		super.write(ctx, msg, promise);
	}
}
