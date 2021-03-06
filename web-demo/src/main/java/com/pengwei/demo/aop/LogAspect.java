package com.pengwei.demo.aop;


import com.github.dadiyang.equator.Equator;
import com.github.dadiyang.equator.FieldInfo;
import com.github.dadiyang.equator.GetterBaseEquator;
import com.pengwei.demo.entity.Customer;
import com.pengwei.demo.service.CustomerService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: pengwei
 * @date: 2020/1/7
 * 切面编程
 */

@Aspect
@Component
public class LogAspect {
    @Autowired
    private CustomerService customerService;

    private Customer oldcustomer;

    @Pointcut("execution(public * com.pengwei.demo.controller.TestController.update(..))")
    public void webLog() {
    }

    @Pointcut("execution(public * com.pengwei.demo.controller.TestController.index(..))")
    public void test() {
    }
//    @After("test()")
//    public void doBefore(JoinPoint joinPoint) throws Throwable {
////        // 接收到请求，记录请求内容
////        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
////        HttpServletRequest request = attributes.getRequest();
////        // 记录下请求内容
////        System.out.println("URL : " + request.getRequestURL().toString());
////        System.out.println("HTTP_METHOD : " + request.getMethod());
////        System.out.println("IP : " + request.getRemoteAddr());
////        System.out.println("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
////        System.out.println("ARGS : " + Arrays.toString(joinPoint.getArgs()));
//
//
//        // 拦截的实体类，就是当前正在执行的controller
//        Object target = joinPoint.getTarget();
//        // 拦截的方法名称。当前正在执行的方法
//        String methodName = joinPoint.getSignature().getName();
//        // 拦截的方法参数
//        Object[] args = joinPoint.getArgs();
//       Model model = (Model) args[0];
//        // 拦截的放参数类型
//        Signature sig = joinPoint.getSignature();
//        System.out.println("拦截的Controller：" + target);
//        System.out.println("方法名称：" + methodName);
//        System.out.println("拦截的参数类型：" + sig);
//        oldcustomer = (Customer) model.getAttribute("data");
////        System.out.println(oldcustomer.toString());
//
//        //oldcustomer = customerService.findId(customer.getId());
//    }


//    @AfterReturning(returning = "ret", pointcut = "webLog()")
//    public void doAfterReturning(Object ret,JoinPoint joinPoint) throws Throwable {
//
//        System.out.println(ret);
//    }
//
//    //后置异常通知
//    @AfterThrowing("webLog()")
//    public void throwss(JoinPoint jp) {
//        System.out.println("方法异常时执行.....");
//    }

//    //后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
//    @After("webLog()")
//    public void after(JoinPoint joinPoint) {
//        System.out.println("方法最后执行.....");
//        //Object o = joinPoint.();
//
//        // 拦截的实体类，就是当前正在执行的controller
//        Object target2 = joinPoint.getTarget();
//        // 拦截的方法名称。当前正在执行的方法
//        String methodName2 = joinPoint.getSignature().getName();
//        // 拦截的方法参数
//        Object[] args2 = joinPoint.getArgs();
//        Customer customer2 = (Customer) args2[0];
//        // 拦截的放参数类型
//        Signature sig2 = joinPoint.getSignature();
//        System.out.println("拦截的Controller：" + target2);
//        System.out.println("方法名称：" + methodName2);
//        System.out.println("法参数[0]：" + customer2.toString());
//        System.out.println("拦截的参数类型：" + sig2);
//
//        System.out.println("修改前后比较---");
//        Map<String, String> compareObjectDataMap = compareObject(oldcustomer, customer2);
//        System.out.println(compareObjectDataMap);
//        System.out.println("old对象：" + oldcustomer.toString());
//        System.out.println("new对象：" + customer2.toString());
//    }


    // 环绕通知,环绕增强，相当于MethodInterceptor
    @Around("webLog()")
    public Object arround(ProceedingJoinPoint pjp) {
        String targetName = pjp.getTarget().getClass().getName();
        Class targetClass = null;
        try {
            targetClass = Class.forName(targetName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Method[] methods = targetClass.getMethods();
        String methodName = pjp.getSignature().getName();
        //
        Object[] arguments = pjp.getArgs();
        String role = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    role = method.getAnnotation(SystemLog.class).role();
                    break;
                }
            }
        }

        if ("客户".equals(role)) {
            // 拦截的方法参数
//            Object[] args2 = pjp.getArgs();
            Customer customer = (Customer) arguments[0];


            Customer oldCustomer = customerService.findId(customer.getId());
            System.out.println("方法环绕start.....");

            try {
                Object result = pjp.proceed();
                System.out.println("方法环绕proceed，结果是 :" + result);
                // 拦截的类，就是当前正在执行的controller
                //Object target2 = pjp.getTarget().getClass().getName();
                // 拦截的方法名称。当前正在执行的方法
//                String methodName2 = pjp.getSignature().getName();
//                 拦截的放参数类型
//                Signature signature = pjp.getSignature();
//            System.out.println("拦截的Controller：" + target2);
//            System.out.println("方法名称：" + methodName2);
//            System.out.println("拦截的参数类型：" + signature);


                System.out.println("修改前后比较:");
                Equator equator = new GetterBaseEquator();
                List<FieldInfo> diff = equator.getDiffFields(oldCustomer, customer);
                for (FieldInfo fieldInfo : diff) {
                    String modificationLog = fieldInfo.getFieldName() + ":" + fieldInfo.getFirstVal() + "变更为：" + fieldInfo.getSecondVal();
                    System.out.println(modificationLog);
                }
                return result;
            } catch (Throwable e) {
                e.printStackTrace();
                return null;
            }
        }


        return null;


    }

    /**
     * 对象前后比较
     *
     * @param oldBean
     * @param newBean
     * @return
     */
    public static Map<String, String> compareObject(Object oldBean, Object newBean) {
        Map<String, String> resultMap = new HashMap<String, String>();
        try {
            Class clazz = oldBean.getClass();
            Field[] fields = oldBean.getClass().getDeclaredFields();

            for (Field field : fields) {
                PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
                Method getMethod = pd.getReadMethod();
                Object o1 = getMethod.invoke(oldBean);
                Object o2 = getMethod.invoke(newBean);
                if (o1 == null || o2 == null) {
                    continue;
                }
                if (!o1.toString().equals(o2.toString())) {
                    resultMap.put(field.getName(), "变更前:" + o1.toString() + " 变更后:" + o2.toString());

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultMap;


    }

    protected Object deepClone(Object source) throws Exception {
        //序列化
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);

        oos.writeObject(source);

        //反序列化
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);

        return ois.readObject();
    }

}
