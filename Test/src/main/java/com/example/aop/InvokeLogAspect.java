package com.example.aop;

import com.example.Mapper.UserMapperImp;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class InvokeLogAspect {

    public static final Logger logger = LoggerFactory.getLogger(UserMapperImp.class);

    //指定哪些连接点为切点
    @Pointcut("@annotation(com.example.annotation.InvokeLog)")
    public void pc(){

    }
    //在切点位置切入什么方法增强
    @Around("pc()")
    public Object printInvokeLog(ProceedingJoinPoint joinPoint){
        //目标方法调用前
        Object proceed = null;
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getMethod().getName();
        logger.info(methodName+"即将被调用");
        //System.out.println(methodName+"即将被调用");
        try {
            proceed = joinPoint.proceed();
            //目标方法调用后
            logger.info(methodName+"被调用完了");
            //System.out.println(methodName+"被调用完了");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            //目标方法出现异常了
            logger.info(methodName+"出现了异常");
            //System.out.println(methodName+"出现了异常");
        }
        return proceed;
    }

}
