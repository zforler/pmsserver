package com.wk.access;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.wk.platform.*","com.wk.commonservice.service"})
@ComponentScan(basePackages = {"com.wk.*"})
@EnableJpaRepositories(basePackages = {"com.wk.*"})
@EntityScan(basePackages = "com.wk.bean")
public class AccessApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccessApplication.class, args);

    }
}
