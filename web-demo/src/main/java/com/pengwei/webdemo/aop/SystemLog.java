package com.pengwei.webdemo.aop;


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
public @interface SystemLog {
    //String module()  default "";
    //String operationType() default "";
    String role() default "";

}
/*      String targetName = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            Object[] arguments = joinPoint.getArgs();
            Class targetClass = Class.forName(targetName);
            Method[] methods = targetClass.getMethods();
            String operationType = "";
            String operationName = "";
             for (Method method : methods) {
                 if (method.getName().equals(methodName)) {
                    Class[] clazzs = method.getParameterTypes();
                     if (clazzs.length == arguments.length) {
                         module = method.getAnnotation(SystemLog.class).module();
                         operationType = method.getAnnotation(SystemLog.class).operationType();
                         break;
                    }
                }
            }

 */
