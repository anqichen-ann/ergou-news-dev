package com.ergou.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages = {"com.ergou"})
@MapperScan(basePackages = "com.ergou.user.mapper")
@EnableEurekaClient
@EnableCircuitBreaker
public class user {

    public static void main(String[] args) {
        SpringApplication.run(user.class, args);
    }
}
