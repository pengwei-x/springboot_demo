package com.peng.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 注解测试Aop
 * @author pengwei
 * @date 2020/6/12
 */
//切面类
@Aspect
@Component
public class MyAdviceToAnoation {

    @Pointcut("execution(public * com.peng.spring.aop.*ServiceImpl.*(..))")
    public void test() {
        System.out.println("111");
    }

    @After("test()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        System.out.println("前置通知test ");
    }
}
