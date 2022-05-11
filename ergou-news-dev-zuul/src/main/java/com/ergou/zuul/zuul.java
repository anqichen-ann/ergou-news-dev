package com.ergou.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication(scanBasePackages = {"com.ergou"}, exclude = DataSourceAutoConfiguration.class)
@EnableZuulProxy
public class zuul {

    public static void main(String[] args) {
        SpringApplication.run(zuul.class, args);
    }
}
