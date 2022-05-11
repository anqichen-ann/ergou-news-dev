package com.ergou.zuul.controller;

import com.ergou.api.user.HelloControllerApi;
import com.ergou.grace.result.GraceJSONResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController implements HelloControllerApi {

    public Object hello() {
        return GraceJSONResult.ok("登录成功！");

    }

}
