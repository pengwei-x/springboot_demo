package com.pengwei.test01.springboot_demo.aop;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
/**
 * @author: pengwei
 * @date: 2020/1/19
 * 在拦截之前，我们需要额外的自定义一个注解
 */
public @interface SystemLog{
    //String module()  default "";
    String methods()  default "";
}
