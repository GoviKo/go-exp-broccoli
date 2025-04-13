package io.goviko.aspect.aspectdemo;

import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* io.goviko.aspect.aspectdemo.AppService.*(..))")
    public void logBeforeMethodExecution() {
        logger.info("A method in the service package is about to be executed.");
    }

    @Before("execution(* io.goviko.aspect.aspectdemo.AppService.*(..))")
    public void logBeforeMethodExecution(JoinPoint joinPoint) {
        logger.info("Entering method: " + joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(* io.goviko.aspect.aspectdemo.AppService.*(..))")
    public void logAfterMethodExecution(JoinPoint joinPoint) {
        logger.info("Exiting method: " + joinPoint.getSignature().getName());
    }

    @AfterThrowing(pointcut = "execution(* io.goviko.aspect.aspectdemo.AppService.*(..))", throwing = "error")
    public void logAfterException(JoinPoint joinPoint, Throwable error) {
        logger.error("Exception in method: " + joinPoint.getSignature().getName() + " with error: " + error.getMessage());
    }

    @Around("execution(* io.goviko.aspect.aspectdemo.AppService.*(..))")
    public Object monitorServicePerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.nanoTime();
        Object result = joinPoint.proceed();
        double duration = (System.nanoTime() - startTime)/1.0E6;
        logger.info("Execution time of {}  :  {} ms", joinPoint.getSignature().getName(), duration);
        return result;
    }

    @Around("execution(* io.goviko.aspect.aspectdemo.AppController.*(..))")
    public Object monitorControllerPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.nanoTime();
        Object result = joinPoint.proceed();
        double duration = (System.nanoTime() - startTime)/1.0E6;
        logger.info("Execution time of {}  :  {} ms", joinPoint.getSignature().getName(), duration);
        return result;
    }
}
