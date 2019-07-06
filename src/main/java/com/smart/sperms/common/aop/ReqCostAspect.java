package com.smart.sperms.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Descript 记录controller层方法执行耗时
 * @Version 1.0
 */
@Aspect
@Component
public class ReqCostAspect {

    private Logger logger = LoggerFactory.getLogger(ReqCostAspect.class);
    //耗时时间
    private long spendTime = 0L;

    /**
     * 定义拦截方法规则
     */
    @Pointcut("execution(public * com.smart.sperms.controller.*.*(..))")
    public void spendTimeLog() {}

    /**
     * 获取方法执行耗时时间
     * @param point 切点
     * @return
     * @throws Throwable
     */
    @Around("spendTimeLog()")
    public Object sqlLogAround(ProceedingJoinPoint point) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = point.proceed();
        spendTime = System.currentTimeMillis() - start;
        return result;
    }

    /**
     * 记录执行方法和执行耗时时间
     * @param joinPoint 切点信息
     */
    @AfterReturning(value = "spendTimeLog()")
    public void sqlLogAfter(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        //记录耗时
        logger.info("{}方法执行耗时：{}ms", method, spendTime);
    }

}
