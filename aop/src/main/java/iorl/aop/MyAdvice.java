package iorl.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {
    private Logger logger = LoggerFactory.getLogger(MyAdvice.class);

    @Pointcut(value = "(execution(* iorl.aop.controller.*.*(..)))")
    public void pointcut(){

    }
    @Around("pointcut()")
    public void logAdvice(ProceedingJoinPoint p) throws Throwable {
        String s = p.getClass().toString();
        String method = p.getSignature().getName();
        Object[] args = p.getArgs();
        ObjectMapper mapper = new ObjectMapper();
        logger.info("s:{}, method:{}, args:{}", s, method, mapper.writeValueAsString(args));
        Object proceed = p.proceed(args);
        System.out.println("proceed: "+proceed);
        logger.info("s:{}, method:{}, args:{}", s, method, mapper.writeValueAsString(proceed));

    }
}
