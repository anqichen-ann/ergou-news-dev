package com.ergou.springcloud.controller;

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

    final static Logger logger = LoggerFactory.getLogger(HelloController.class);

    public Object hello() {
        logger.info("Hello~");
        return GraceJSONResult.ok("登录成功！");

    }

}
