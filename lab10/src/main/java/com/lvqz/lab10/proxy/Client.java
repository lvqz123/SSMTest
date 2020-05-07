package com.lvqz.lab10.proxy;

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
         *  基于接口的动态代理：
         *      涉及的类：Proxy
         *      提供者：JDK官方
         *  如何创建代理对象：
         *      使用Proxy类中的newProxyInstance方法
         *  创建代理对象的要求：
         *      被代理类最少实现一个接口，如果没有则不能使用
         *  newProxyInstance方法的参数：
         *      ClassLoader：类加载器
         *          它是用于加载代理对象字节码的。和被代理对象使用相同的类加载器。固定写法。
         *      Class[]：字节码数组
         *          它是用于让代理对象和被代理对象有相同方法。固定写法。
         *      InvocationHandler：用于提供增强的代码
         *          它是让我们写如何代理。我们一般都是些一个该接口的实现类，通常情况下都是匿名内部类，但不是必须的。
         *          此接口的实现类都是谁用谁写。
         */
        System.out.println(producer.getClass().getInterfaces());
        IProducer proxyProducer = (IProducer)Proxy.newProxyInstance(producer.getClass().getClassLoader(), producer.getClass().getInterfaces(), new InvocationHandler() {
            /**
             * 作用：执行被代理对象的任何接口方法都会经过该方法
             * 方法参数的含义
             * @param proxy   代理对象的引用
             * @param method  当前执行的方法
             * @param args    当前执行方法所需的参数
             * @return        和被代理对象方法有相同的返回值
             * @throws Throwable
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                Object returnValue = null;
                Float money = (Float) args[0];
                //厂家转给代理去卖之后自己能挣多少（原本10000，现在8000,2000被代理中间商赚了差价）
                returnValue = method.invoke(producer,money*0.8f);
                return returnValue;
//                return method.invoke(producer,args);
            }
        });
        proxyProducer.saleProduce(10000f);


        //第二种实现方法
        IProducer proxyProducer1 = (IProducer)Proxy.newProxyInstance(IProducer.class.getClassLoader(), /*producer.getClass().getInterfaces()*/new Class[]{IProducer.class} , new InvocationHandler() {
            IProducer producer = new Producer();
            /**
             * 作用：执行被代理对象的任何接口方法都会经过该方法
             * 方法参数的含义
             * @param proxy   代理对象的引用
             * @param method  当前执行的方法
             * @param args    当前执行方法所需的参数
             * @return        和被代理对象方法有相同的返回值
             * @throws Throwable
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                Object returnValue = null;
                Float money = (Float) args[0];
                //厂家转给代理去卖之后自己能挣多少（原本10000，现在8000,2000被代理中间商赚了差价）
                returnValue = method.invoke(producer,money*0.8f);
                return returnValue;
//                return method.invoke(producer,args);
            }
        });

        proxyProducer1.saleProduce(10000f);



    }

}
