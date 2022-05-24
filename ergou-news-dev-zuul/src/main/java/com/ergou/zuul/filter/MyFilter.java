package com.ergou.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class MyFilter extends ZuulFilter {
    @Value("${blackIp.continueCounts}")
    private Integer continueCounts;
    @Value("${blackIp.limitTimes}")
    private Integer limitTimes;
    @Value("${blackIp.timeInterval}")
    private Integer timeInterval;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("my filter ~~~");
        System.out.println("continueCounts: " + continueCounts);
        System.out.println("limitTimes: " + limitTimes);
        System.out.println("timeInterval: " + timeInterval);
        return null;
    }
}
