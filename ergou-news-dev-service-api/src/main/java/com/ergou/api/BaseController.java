package com.ergou.api;

import com.ergou.utils.RedisOperator;
import com.ergou.utils.SMSUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class BaseController {

    @Autowired
    public RedisOperator redis;

    @Autowired
    public SMSUtils smsUtils;

    @Value("${website.domain-path}")
    public String domain;

    public static final String SMS_CODE = "mobile:SMSCode";

    public static Integer MAX_AGE_OF_MONTH = 30*24*60*60;

    public void setCookie(HttpServletResponse response,
                          String cookieName,
                          String cookieValue,
                          Integer maxAge) throws UnsupportedEncodingException {
        String encodedCookieValue = URLEncoder.encode(cookieValue, "UTF8");
        Cookie cookie = new Cookie(cookieName, encodedCookieValue);
        cookie.setDomain(domain);
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);

    }

}
