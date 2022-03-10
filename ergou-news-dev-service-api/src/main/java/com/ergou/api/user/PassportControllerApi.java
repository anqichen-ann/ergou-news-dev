package com.ergou.api.user;

import com.ergou.grace.result.GraceJSONResult;
import com.ergou.request.LoginDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


@Api(value = "get SMS code", tags = {"get SMS code 的controller"})
@RequestMapping("passport")
public interface PassportControllerApi {

    @ApiOperation(value = "get SMS code", notes = "get SMS code", httpMethod = "GET")
    @GetMapping("/SMSCode")
    GraceJSONResult getSMSCode(@RequestParam String mobile, HttpServletRequest request) throws Exception;

    @ApiOperation(value = "login", notes = "login", httpMethod = "POST")
    @PostMapping("/login")
    GraceJSONResult login(@RequestBody @Valid LoginDto loginDto,
                          BindingResult bindingResult,
                          HttpServletRequest request,
                          HttpServletResponse response) throws Exception;

    @ApiOperation(value = "log out", notes = "log out", httpMethod = "GET")
    @GetMapping("/logOut")
    GraceJSONResult logOut(@RequestParam("userId") long userId,
                          HttpServletRequest request,
                          HttpServletResponse response) throws Exception;

}
