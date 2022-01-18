package com.ergou.user.controller;

import com.ergou.api.BaseController;
import com.ergou.api.user.PassportControllerApi;
import com.ergou.grace.result.GraceJSONResult;
import com.ergou.utils.IPUtil;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
}
