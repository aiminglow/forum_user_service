package com.aiming.low.forum_user_service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.aiming.low.forum_user_service.dao")
public class ForumUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForumUserServiceApplication.class, args);
    }

}
