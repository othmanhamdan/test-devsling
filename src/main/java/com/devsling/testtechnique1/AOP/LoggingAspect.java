package com.devsling.testtechnique1.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* com.devsling.testtechnique1.services.CarService.*(..)) || execution(* com.devsling.testtechnique1.controller.CarController.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();

        logger.info("{} - {}() executed in {} ms", className, methodName, executionTime);

        return result;
    }
}
