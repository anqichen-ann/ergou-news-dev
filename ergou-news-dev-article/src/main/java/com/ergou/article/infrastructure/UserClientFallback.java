package com.ergou.article.infrastructure;

import com.ergou.grace.result.GraceJSONResult;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements FallbackFactory<UserClient> {
    @Override
    public UserClient create(Throwable throwable) {
        return new UserClient() {
            @Override
            public GraceJSONResult hello() {
                System.out.println("进入熔断降级（服务端）");
                return GraceJSONResult.ok();
            }
        };
    }
}
