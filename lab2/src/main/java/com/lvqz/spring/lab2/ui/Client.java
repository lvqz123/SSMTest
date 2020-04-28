package com.lvqz.spring.lab2.ui;

import com.lvqz.spring.lab2.service.IAccountService;
import com.lvqz.spring.lab2.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author: lvqz
 * @date: 2020/4/27
 * @time: 21:54
 *
 * 模拟一个表现层，用于调用业务层
 *
 */
public class Client {

    public static void main(String[] args) {
//        IAccountService as = new AccountServiceImpl();
        /**
         *
         * 获取核心容器对象
         *
         * ApplicationContext的三个常用实现类：
         *         ClassPathXmlApplicationContext: 它可以加载类路径下的配置文件，要求配置文件必须在类路径下。不在的话，加载不了。 （更常用）
         *         FileSystemXmlApplicationContext： 它可以加载磁盘任意路径下的配置文件（必须有访问权限）
         *
         *         AnnotationConfigApplicationContext：它是用于读取注解创建容器的。
         *
         *
         * 核心两个接口引发出的问题：
         * ApplicationContext：   更适用于单例模式，（默认模式）
         *      它在构建核心容器时，创建对象采用的策略是采用立即加载的方式。也就是说，一加载完配置文件就进行初始化。
         * BeanFactory：         更适用于多例模式。
         *      它在构建核心容器时，创建对象采用的策略是采用延迟加载的方式。也就是说，加载完配置文件后不进行初始化，什么时候使用，什么时候初始化。
         *
         *
         */
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //使用FileSystemXMLApplicationContext
//        ApplicationContext ac = new FileSystemXmlApplicationContext("C:\\Users\\Administrator\\Desktop\\bean.xml");
        //根据id获取Bean对象
//        IAccountService as = (IAccountService) ac.getBean("accountService");

//        as.saveAccount();

//        ----------BeanFactory-----------
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        IAccountService as = (IAccountService) beanFactory.getBean("accountService");
        as.saveAccount();

    }

}
