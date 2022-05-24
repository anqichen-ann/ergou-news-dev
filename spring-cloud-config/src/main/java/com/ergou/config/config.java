package com.ergou.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = {"com.ergou"}, exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
@EnableConfigServer
public class config {

    public static void main(String[] args) {
        SpringApplication.run(config.class, args);
    }
}
