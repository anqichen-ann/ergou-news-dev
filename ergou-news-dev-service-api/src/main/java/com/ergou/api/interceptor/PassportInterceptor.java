package com.ergou.api.interceptor;

import com.ergou.exception.GraceException;
import com.ergou.exception.MyCustomException;
import com.ergou.grace.result.ResponseStatusEnum;
import com.ergou.utils.IPUtil;
import com.ergou.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PassportInterceptor implements HandlerInterceptor {

    @Autowired
    public RedisOperator redis;

    public static final String SMS_CODE = "mobile:SMSCode";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String userIp = IPUtil.getRequestIp(request);
        boolean keyIsExist = redis.keyIsExist(SMS_CODE + ":" + userIp);
        if (keyIsExist) {
            GraceException.display(ResponseStatusEnum.SMS_NEED_WAIT_ERROR);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
