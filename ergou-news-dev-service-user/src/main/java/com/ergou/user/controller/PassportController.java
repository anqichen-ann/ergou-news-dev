package com.ergou.user.controller;

import com.ergou.api.BaseController;
import com.ergou.api.user.PassportControllerApi;
import com.ergou.grace.result.GraceJSONResult;
import com.ergou.grace.result.ResponseStatusEnum;
import com.ergou.request.LoginDto;
import com.ergou.utils.IPUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PassportController extends BaseController implements PassportControllerApi {

    @Override
    public GraceJSONResult getSMSCode(String mobile, HttpServletRequest request) throws Exception {
        String userIp = IPUtil.getRequestIp(request);
        redis.setnx60s(SMS_CODE + ":" + userIp, userIp);
        String randomCode = (int) (Math.random() * 9 + 1) * 100000 + "";
        redis.set(SMS_CODE + ":" + mobile, randomCode);

        smsUtils.sendSMS("15871787970", randomCode);
        return GraceJSONResult.ok();
    }

    @Override
    public GraceJSONResult login(LoginDto loginDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = getErrors(bindingResult);
            return GraceJSONResult.errorMap(errors);
        }
        String mobile = loginDto.getMobile();
        String smsCode = loginDto.getSMSCode();

        String redisSMSCode = redis.get(SMS_CODE + ":" + mobile);
        if (StringUtils.isBlank(redisSMSCode) || !redisSMSCode.equals(smsCode)) {
            return GraceJSONResult.errorCustom(ResponseStatusEnum.SMS_CODE_ERROR);
        }
        return GraceJSONResult.ok();
    }

    public Map<String, String> getErrors(BindingResult bindingResult) {
        Map<String, String> errorMap = new HashMap<>();
        bindingResult.getFieldErrors()
                .forEach(error -> errorMap.put(error.getField(), error.getDefaultMessage()));
        return errorMap;
    }
}
