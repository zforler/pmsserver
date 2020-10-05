package com.wk.access.client;

import com.wk.access.server.transfer.ITransferFactory;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class EquipmentClientManager implements InitializingBean {
	protected static Logger logger = LoggerFactory.getLogger(EquipmentClientManager.class);

	public static final ConcurrentHashMap<String, EquipmentClient> equipmentClient = new ConcurrentHashMap<>();

	@Override
	public void afterPropertiesSet() throws Exception {

	}
}
