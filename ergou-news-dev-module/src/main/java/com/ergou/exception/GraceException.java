package com.ergou.exception;

import com.ergou.grace.result.ResponseStatusEnum;

public class GraceException {

    public static void display(ResponseStatusEnum responseStatusEnum) {
        throw new MyCustomException(responseStatusEnum);
    }
}
