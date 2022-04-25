package com.ergou.article;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = {"com.ergou"})
@EnableEurekaClient
public class article {

    public static void main(String[] args) {
        SpringApplication.run(article.class, args);
    }
}
