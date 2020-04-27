package com.lvqz.spring.lab1.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author: 吕秋圳
 * @date: 2020/4/27
 * @time: 21:58
 *
 * 一个创建Bean对象的工厂
 *
 * Bean：在计算机英语中，有可重用组件的含义
 *
 * JavaBean:  用java语言编写的可重用组件
 *        javabean != 实体类
 *        javabean >  实体类
 *
 * 它就是创建我们的service和dao对象的
 *
 * 第一个：需要一个配置文件配置我们的service和dao
 * 第二个：通过读取配置文件中配置的内容，反射创建对象
 *
 */
public class BeanFactory {

    //定义一个Properties对象
    private static Properties props;
    private static Map<String,Object> beans;

    //使用静态代码块来为Properties对象赋值
    static {
        try {
            //实例化对象
            props = new Properties();
            //获取Properties文件的流对象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("beanFactory.properties");
            props.load(in);

            //通过静态代码块实现单例（静态代码块只会在类加载之后执行一次）
            //实例化容器
            beans = new HashMap<String, Object>();
            //取出配置文件中所有的key
            Enumeration<Object> keys = props.keys();
            //遍历枚举
            while (keys.hasMoreElements()){
                //取出每个key
                String key = keys.nextElement().toString();
                System.out.println(key);
//                System.out.println(props.get(key));
                //反射创建对象
                Object value = Class.forName(props.getProperty(key)).newInstance();
                beans.put(key,value);
            }

        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties失败！");
        }
    }


    //单例模式，直接拿取创建好的Map容器中的对象
    public static Object getBean(String beanName){
        return beans.get(beanName);

    }

   /*
    多例模式，效率不够高
    public static Object getBean(String beanName){
        Object bean = null;
        try {
            bean =Class.forName(props.getProperty(beanName)).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return bean;

    }*/





}
