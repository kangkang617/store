package com.kangkang.store.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * ClassName:TimerAspect
 * Package:com.kangkang.store.aop
 * Description:
 *
 * @date:2022/3/29 9:41
 * @author:kangkang
 */
@Component
@Aspect
public class TimerAspect  {
//    配置连接点
    @Around("execution(* com.kangkang.store.service.impl.*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        long star = System.currentTimeMillis();

        Object result = pjp.proceed();

        long end = System.currentTimeMillis();

        System.out.println("耗时：" + (end-star)+"ms");

        return result;
    }

}
