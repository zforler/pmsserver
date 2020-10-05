package com.wk.access.handler;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 将收到的信息显示在日志中
 * **/
public class ReaderShowDataHandler extends SimpleChannelInboundHandler<ByteBuf> {
	protected static Logger logger = LoggerFactory.getLogger(ReaderShowDataHandler.class);
    
    @Override
	protected void channelRead0(ChannelHandlerContext ctx, ByteBuf buf) throws Exception {
		StringBuilder buffer = new StringBuilder("received from:" + ctx.channel().remoteAddress() + ", length:");
		buffer.append(buf.readableBytes()).append(" data:");
		buffer.append(ByteBufUtil.hexDump(buf));
		
		logger.info(buffer.toString());
		
		buf.retain();
		ctx.fireChannelRead(buf);		
	}

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // 拦截SLB的IO异常
        String message = cause.getMessage();
        if(message.contains("远程主机强迫关闭了一个现有的连接") || message.contains("Connection reset by peer")){
            
        }else{
            super.exceptionCaught(ctx, cause);
        }
            
    }
    
}
