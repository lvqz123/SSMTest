package com.lvqz.lab11.util;

/**
 * @author: lvqz
 * @date: 2020/5/18
 * @time: 16:14
 *
 * 日志类，用来测试AOP的
 *
 */
public class Logger {

    /**
     * 用于打印日志，计划让其在切入点方法执行之前执行（切入点方法为业务层方法）
     */
    public void printLog(){
        System.out.println("Logger类中的printLog方法开始记录日志了。。");
    }

}
