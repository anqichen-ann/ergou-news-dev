package com.ergou.api.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;


@Api(value = "Hello", tags = {"say hello 的controller"})
public interface HelloControllerApi {

    @ApiOperation(value = "say hello~", notes = "say hello~", httpMethod = "GET")
    @GetMapping("/hello")
    Object hello();
}
