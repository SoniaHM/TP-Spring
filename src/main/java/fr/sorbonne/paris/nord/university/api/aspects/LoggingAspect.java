package fr.sorbonne.paris.nord.university.api.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Around("@annotation(fr.sorbonne.paris.nord.university.api.annotations.Loggable)")
    public Object doLogging(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        final String methodName = proceedingJoinPoint.getSignature().getName();
        log.info("Executing {} ...", methodName);
        StopWatch sw = new StopWatch();
        sw.start();
       Object result = proceedingJoinPoint.proceed();
        sw.stop();
        log.info("Executed {} in {} ms", methodName, sw.getTotalTimeMillis());
        return result;
    }
}
