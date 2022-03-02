package com.agus.EjercicioGen.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExecutionTimeTrackerAdvice {

    private Logger logger = LoggerFactory.getLogger(ExecutionTimeTrackerAdvice.class);

    @Around("execution(* com.agus.EjercicioGen..*(..))")
    public Object trackTime(ProceedingJoinPoint time) throws Throwable {
        long startTime=System.currentTimeMillis();
         Object timeMethodResult=time.proceed();
        long endTime=System.currentTimeMillis();
        logger.info("Method: "+time.getSignature()+"Time taken to execute: "+(endTime-startTime));
        return timeMethodResult;
    }



}
