package com.wk.access.server.connection;


import com.wk.access.message.Message;
import com.wk.access.server.transfer.ITransfer;
import com.wk.access.server.transfer.ITransferFactory;
import com.wk.access.server.transfer.UnresendTransfer;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.AttributeKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client implements ITransfer {
	protected static Logger logger = LoggerFactory.getLogger(Client.class);
	public final static AttributeKey<Client> ATTR = AttributeKey.valueOf("client");

	protected String equipmentId;
	
	//是否在线
	protected volatile boolean online;
	//连接
	protected Channel channel;

	protected int protocol;
	//
	protected ITransferFactory transferFactory;
	protected ITransfer transfer;
	

	public void setTransferFactory(ITransferFactory transferFactory) {
		this.transferFactory = transferFactory;
	}

	/**
	 * 
	 */
	public Client() {
		this.online = false;
	}

	public Client(String equipmentId, boolean online, Channel channel) {
		this.equipmentId = equipmentId;
		this.online = online;
		this.channel = channel;
		
		this.transfer = new UnresendTransfer(channel);
	}

	public String getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	/**
	 * @return the online
	 */
	public boolean isOnline() {
		return online;
	}


	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	/**
	 * 发送信息
	 */
	public void transfer(Message message) {
		transfer.transfer(message);
	}


	public void handled(Channel ch) {
		
		ch.attr(Client.ATTR).set(this);
		if(!ch.equals(this.channel)) {
			this.channel = ch;
			this.transfer = this.transferFactory.createTransfer(ch);
		}
		this.online = true;
		

		logger.info("client handled, channel:" + ch.remoteAddress().toString() + " client:" + this.equipmentId);
	}

	public void readerTimeout(ChannelHandlerContext ctx) {
		ctx.close();
		logger.info("reader timeout, channel:" + ctx.channel().remoteAddress().toString() + " client:" + this.equipmentId);
	}

	public void writeTimeout(Channel ch) {
		if(ch.equals(this.channel)) {
            logger.error("write timeout 1");
		}else{
            logger.error("write timeout 2");
		}
	}

	/**
	 * 
	 * @param ch
	 */
	public void disconnected(Channel ch) {
		if(this.channel == ch) {
			ch.disconnect();
			ch.close();
			this.online = false;

			this.transfer = null;
			this.channel = null;
			
			logger.info("client disconnected, channel:" + ch.remoteAddress().toString() + " client:" + this.equipmentId );
		}
	}
	public void forceDisconnect(){
		this.disconnected(this.channel);
	}
}
