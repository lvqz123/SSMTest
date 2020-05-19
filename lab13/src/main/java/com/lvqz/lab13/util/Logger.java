package com.lvqz.lab13.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author: lvqz
 * @date: 2020/5/18
 * @time: 16:14
 *
 * 日志类，用来测试AOP的
 *
 * @Aspect：设置为切面类
 *
 */
@Component("logger")
@Aspect
public class Logger {

    @Pointcut("execution( * com.lvqz.lab13.service.impl.*.*(..))")
    private void pt1(){}

    /**
     * 用于打印日志，计划让其在切入点方法执行之前执行（切入点方法为业务层方法）
     */
//    @Before("pt1()")
    public void beforePrintLog(){
        System.out.println("前置通知——Logger类中的beforePrintLog方法开始记录日志了。。");
    }

    /**
     * 用于打印日志，计划让其在切入点方法执行之后执行（切入点方法为业务层方法）
     */
//    @AfterReturning("pt1()")
    public void afterReturningPrintLog(){
        System.out.println("后置通知——Logger类中的afterReturningPrintLog方法开始记录日志了。。");
    }

    /**
     * 用于打印日志，计划让其在切入点方法执行异常执行（切入点方法为业务层方法）
     */
//    @AfterThrowing("pt1()")
    public void afterThrowingPringLog(){
        System.out.println("异常通知——Logger类中的afterThrowingPringLog方法开始记录日志了。。");
    }

    /**
     * 用于打印日志，计划让其在切入点方法执行最后执行（切入点方法为业务层方法）
     */
//    @After("pt1()")
    public void afterPrintLog(){
        System.out.println("最终通知——Logger类中的afterPrintLog方法开始记录日志了。。");
    }

    /**
     * 环绕通知
     * 问题：
     *      当我们配置了环绕通知之后，切入点方法没有执行，而通知方法执行了。
     * 分析：
     *      通过对比动态代理中的环绕通知代码，发现动态代理的环绕通知有明确的切入点方法调用，而我们的代码中没有。
     * 解决：
     *      Spring框架为我们提供了一个接口：ProceedingJoinPoint。该接口有一个方法proceed()，此方法就相当于明确调用切入点方法。
     *      该接口可以作为环绕通知的方法参数，在程序执行时，spring框架会为我们提供该接口的实现类供我们使用。
     *
     * spring中的环绕通知：
     *      它是spring框架为我们提供的一种可以在代码中手动控制增强方法何时执行的方式。
     */
    @Around("pt1()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try {
            //获取方法所执行的参数
            Object[] args = pjp.getArgs();
            System.out.println("Logger类中aroundPrintLog方法开始执行了——前置");
            //明确调用业务层方法（切入点方法）
            rtValue = pjp.proceed(args);
            System.out.println("Logger类中aroundPrintLog方法开始执行了——后置");
            return rtValue;
        } catch (Throwable throwable) {
            System.out.println("Logger类中aroundPrintLog方法开始执行了——异常");
            throw new RuntimeException(throwable);
        } finally {
            System.out.println("Logger类中aroundPrintLog方法开始执行了——最终");
        }
    }




}
