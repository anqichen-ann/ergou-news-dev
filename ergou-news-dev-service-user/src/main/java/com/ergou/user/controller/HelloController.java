package com.ergou.user.controller;

import com.ergou.api.user.HelloControllerApi;
import com.ergou.grace.result.GraceJSONResult;
import com.ergou.utils.RedisOperator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController implements HelloControllerApi {

    @Autowired
    private RedisOperator redisOperator;

    final static Logger logger = LoggerFactory.getLogger(HelloController.class);

    public Object hello() {
        logger.info("Hello~");
        logger.debug("Hello~");
        logger.warn("Hello~");
        logger.error("Hello~");
        return GraceJSONResult.ok("登录成功！");

    }

    @GetMapping("/redis")
    public GraceJSONResult redis() {
        redisOperator.set("age", "18");
        return GraceJSONResult.ok(redisOperator.get("age"));
    }

}
