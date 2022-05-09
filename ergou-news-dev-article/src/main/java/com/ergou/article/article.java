package com.ergou.article;

import com.rule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.ergou"})
@EnableEurekaClient
@EnableFeignClients
//@RibbonClient(name = "service-user", configuration = MyRule.class)
public class article {

    public static void main(String[] args) {
        SpringApplication.run(article.class, args);
    }
}
