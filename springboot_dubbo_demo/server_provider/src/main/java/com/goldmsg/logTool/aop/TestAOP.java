package com.goldmsg.logTool.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Method;

@Aspect
@Component
@Order(-5)
public class TestAOP {

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)"+"&& execution(public * com.goldmsg.logTool.*.*.*(..))")
    public void weblog(){

    }

    @Before(value = "weblog()")
    public void bef(JoinPoint joinpoint){
        joinpoint.getTarget().getClass();
        Method method = ((MethodSignature)joinpoint.getSignature()).getMethod();
        RequestMapping r = method.getAnnotation(RequestMapping.class);

        System.out.println("bef:测试横向切面！！！");
    }

    @Around(value = "weblog()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("测试环绕：前");
        pjp.proceed();
        System.out.println("环绕：后");
    }

    @After(value = "weblog()")
    public void after(JoinPoint joinpoint){
        joinpoint.getTarget().getClass();
        Method method = ((MethodSignature)joinpoint.getSignature()).getMethod();
        RequestMapping r = method.getAnnotation(RequestMapping.class);

        System.out.println("after:测试横向切面！！！");
    }

}
