package com.project.hamroschool.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
@Slf4j
@Aspect
@Component
public class LoggerAspect {
    @Around("execution(* com.project.hamroschool.*.*(..))")
    public Object logger(ProceedingJoinPoint proceedingJoinPoint) throws  Throwable{
        Instant start= Instant.now();
        log.info("Start Execution of"+ proceedingJoinPoint.getSignature().toString());
       Object result= proceedingJoinPoint.proceed();
        log.info("Finished Execution of"+ proceedingJoinPoint.getSignature().toString());
       Instant finish= Instant.now();
       long duration= Duration.between(start, finish).toMillis();
       return result;
    }
    @AfterThrowing(value= "execution(* com.project.hamroschool.*.*(..))", throwing = "ex")
    public void globalExceptionLogger(JoinPoint joinPoint, Exception ex){
       log.info("Exceptin at method"+ joinPoint.getSignature()+ex.getMessage());
    }
}
