package com.ergou.user.controller;

import com.ergou.api.user.HelloControllerApi;
import com.ergou.grace.result.GraceJSONResult;
import com.ergou.utils.RedisOperator;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController implements HelloControllerApi {

    @Autowired
    private RedisOperator redisOperator;

    @Value("${server.port}")
    private String port;

    final static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @HystrixCommand(fallbackMethod = "helloFallBack")
    public Object hello() {
//        int a = 1 / 0;

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("MyPort:" + port);
        return GraceJSONResult.ok("登录成功！");

    }

    public Object helloFallBack() {
        System.out.println("helloFallBack:" + port);
        return GraceJSONResult.ok("降级！");
    }

    @GetMapping("/redis")
    public GraceJSONResult redis() {
        redisOperator.set("age", "18");
        return GraceJSONResult.ok(redisOperator.get("age"));
    }

}
