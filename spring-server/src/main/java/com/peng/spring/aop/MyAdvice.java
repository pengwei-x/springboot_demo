package com.peng.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * @author pengwei
 * @date 2020/6/12
 */

@Component
public class MyAdvice {

    private static final Logger logger = LoggerFactory.getLogger(MyAdvice.class);

    public void before() {
        logger.info("前置通知");
    }

    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        logger.info("环绕通知前");
        Object proceed = proceedingJoinPoint.proceed();
        logger.info("环绕通知后");
        return  proceed;

    }

    public void after() {
        logger.info("后置通知");
    }

    public void afterReturning() {
        logger.info("后置通知(出现异常不会调用)");
    }

    public void afterException() {
        logger.info("");
    }


}
