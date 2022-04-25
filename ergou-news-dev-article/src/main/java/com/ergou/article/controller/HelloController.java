package com.ergou.article.controller;

import com.ergou.api.user.HelloControllerApi;
import com.ergou.grace.result.GraceJSONResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController implements HelloControllerApi {

    final static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    public Object hello() {
        logger.info("Hello~");
        List<ServiceInstance> instances = discoveryClient.getInstances("service-user");
        String hostName = instances.get(0).getHost();
        int port = instances.get(0).getPort();
        System.out.println("hostName :" + hostName + "port: " + port);
        return GraceJSONResult.ok("登录成功！");

    }

}
