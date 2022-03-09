package com.ergou.api.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceLogAspect {
    final static Logger logger = LoggerFactory.getLogger(ServiceLogAspect.class);

    @Around("execution(* com.ergou.*.serviceImp..*.*(..))")
    public Object recordServiceLog(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("======开始执行 {}.{}======",
                joinPoint.getTarget().getClass(),
                joinPoint.getSignature().getName());

        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();

        long takeTime = end - start;
        logger.info("当前执行耗时: {}", takeTime);
        return result;
    }
}
