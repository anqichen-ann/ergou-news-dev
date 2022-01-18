package com.ergou.api.user;

import com.ergou.grace.result.GraceJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Api(value = "get SMS code", tags = {"get SMS code 的controller"})
@RequestMapping("passport")
public interface PassportControllerApi {

    @ApiOperation(value = "get SMS code", notes = "get SMS code", httpMethod = "GET")
    @GetMapping("/SMSCode")
    GraceJSONResult getSMSCode(String mobile, HttpServletRequest request) throws Exception;

}
