package com.wk.access.redisMsg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RedisMsgReceiver {
    private final Logger logger = LoggerFactory.getLogger(RedisMsgReceiver.class);

    public void receiveMessage(String message) {
        logger.info("receive:"+message);
    }
}
