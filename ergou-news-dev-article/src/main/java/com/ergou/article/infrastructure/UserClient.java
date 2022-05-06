package com.ergou.article.infrastructure;

import com.ergou.grace.result.GraceJSONResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "service-user")
public interface UserClient {

    @GetMapping("/hello")
    GraceJSONResult hello();
}
