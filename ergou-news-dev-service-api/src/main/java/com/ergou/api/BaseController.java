package com.ergou.api;

import com.ergou.utils.RedisOperator;
import com.ergou.utils.SMSUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {

    @Autowired
    public RedisOperator redis;

    @Autowired
    public SMSUtils smsUtils;

    public static final String SMS_CODE = "mobile:SMSCode";

}
