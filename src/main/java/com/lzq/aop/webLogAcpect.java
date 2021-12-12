package com.lzq.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class webLogAcpect {
    private Logger logger = LoggerFactory.getLogger(webLogAcpect.class);

    @Pointcut("execution(* com.lzq.controller.errorController.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint){
        System.out.println("Before");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = attributes.getRequest();

        logger.info("URL : "+httpServletRequest.getRequestURI().toString());

    }
    @After("webLog()")
    public void doAfter(JoinPoint joinPoint){
        System.out.println("After");
        Object[] sz = joinPoint.getArgs();
        for(Object object:sz){
            System.out.println(object);
        }
    }
    @AfterReturning(value = "webLog()",returning = "val")
    public void doAfterReturning(String val){
        System.out.println("AfterReturning返回的值为："+val);
    }
    @AfterThrowing(value = "webLog()",throwing = "exception")
    public void doAfterThrowing(Exception exception){
        System.out.println("获取的异常是："+exception);
    }
    @Around("webLog()")
    public void doAround(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("AOP Aronud before...");
        System.out.println("输入的参数为：");
        Object[] args = proceedingJoinPoint.getArgs();
        for(int i=0;i<args.length;i++){
            System.out.print(args[i]+" ");
        }
        System.out.println();
        try {
            Object result = proceedingJoinPoint.proceed();
            System.out.println("获取的结果为："+result);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("AOP Aronud after...");
    }
}
