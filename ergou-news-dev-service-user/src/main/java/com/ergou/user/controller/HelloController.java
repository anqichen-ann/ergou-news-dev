package com.ergou.user.controller;

import com.ergou.api.user.HelloControllerApi;
import com.ergou.grace.result.GraceJSONResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController implements HelloControllerApi {

    final static Logger logger = LoggerFactory.getLogger(HelloController.class);

    public Object hello() {
        logger.info("Hello~");
        logger.debug("Hello~");
        logger.warn("Hello~");
        logger.error("Hello~");

//        return "Hello!";
        return GraceJSONResult.ok("登录成功！");

    }

}
