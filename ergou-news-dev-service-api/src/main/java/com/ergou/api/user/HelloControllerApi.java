package com.ergou.api.user;

import org.springframework.web.bind.annotation.GetMapping;

public interface HelloControllerApi {

    @GetMapping("/hello")
    public Object hello();
}
