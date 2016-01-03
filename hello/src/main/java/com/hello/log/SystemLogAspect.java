package com.hello.log;

import com.hello.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by xuan on 2015/12/31.
 */

@Component
@Aspect
public class SystemLogAspect {

    @Autowired
    @Qualifier("logService")
    private LogService logService;

    @Pointcut("execution(* com.hello.service.impl.*.*(..)) " +
            "&& !execution(* com.hello.service.impl.LogServiceImpl.*(..))")
    public void servicePointcut(){

    }

    @Before("servicePointcut()")
    public void log(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();

        System.out.println(className);
        System.out.println(methodName);
    }

}
