package com.lvqz.lab10.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: lvqz
 * @date: 2020/5/7
 * @time: 11:43
 *
 * 模拟一个消费者
 *
 */
@SuppressWarnings("all")
public class Client {

    public static void main(String [] args){

        //在没有代理的时候，厂家直销是这样的
        //匿名内部类调用外部变量，外部变量必须是final修饰的。
        final Producer producer = new Producer();
        //为了不影响下面做动态代理的案例，暂时注释，复习的时候可以解开注释
//        producer.saleProduce(10000f);
        /**
         * 动态代理：
         *  特点：字节码随用随创建，随用随加载
         *  作用：不修改源码的基础上对方法增强
         *  分类：
         *      基于接口的动态代理
         *      基于子类的动态代理
         *  基于子类的动态代理：
         *      涉及的类：Enhancer
         *      提供者：第三方cglib库
         *  如何创建代理对象：
         *      使用Enhancer类中的create方法
         *  创建代理对象的要求：
         *      被代理类不能是最终类 (final修饰的)
         *  create方法的参数：
         *      Class：字节码
         *          它是用于指定被代理对象的字节码。
         *
         *      Callback：用于提供增强的代码
         *          它是让我们写如何代理。我们一般都是些一个该接口的实现类，通常情况下都是匿名内部类，但不是必须的。
         *          此接口的实现类都是谁用谁写。
         *          我们一般写的都是该接口的子接口实现类：MethodInterceptor
         */
        Producer proxyProducer = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             *
             * @param proxy
             * @param method
             * @param args
             * @param methodProxy
             * @return
             * @throws Throwable
             */
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                Object returnValue = null;
                Float money = (Float) args[0];
                //厂家转给代理去卖之后自己能挣多少（原本10000，现在8000,2000被代理中间商赚了差价）
                returnValue = method.invoke(producer, money * 0.8f);
                return returnValue;
            }
        });
        proxyProducer.saleProduce(10000f);


    }

}
