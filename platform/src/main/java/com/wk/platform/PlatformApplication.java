package com.wk.platform;

import com.wk.platform.redisMsg.RedisMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.wk.platform.*","com.wk.commonservice.service"})
@ComponentScan(basePackages = {"com.wk.*"})
@EnableJpaRepositories(basePackages = {"com.wk.*"})
@EntityScan(basePackages = "com.wk.bean")
public class PlatformApplication implements ApplicationListener {
    @Autowired
    RedisMsgService redisMsgService;
    public static void main(String[] args) {
        SpringApplication.run(PlatformApplication.class, args);

    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if(applicationEvent instanceof ApplicationReadyEvent){
            redisMsgService.sendMsg("hellow");
        }

    }
}
