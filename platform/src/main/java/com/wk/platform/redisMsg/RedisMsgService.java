package com.wk.platform.redisMsg;

import com.wk.common.constant.Const;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisMsgService{
    private final Logger logger = LoggerFactory.getLogger(RedisMsgService.class);
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    public void sendMsg(String msg){
        redisTemplate.convertAndSend(Const.P2C,msg);
        logger.info("sendmsg:"+msg);
    }
}
