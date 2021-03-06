package com.lvqz.spring.lab5.ui;

import com.lvqz.spring.lab5.service.IAccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
        /**
         *
         * 获取核心容器对象

         */
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        根据id获取Bean对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
        IAccountService as1 = (IAccountService) ac.getBean("accountService");
        as.saveAccount();
        System.out.println(as.toString());
//        System.out.println(as == as1);
        ((ClassPathXmlApplicationContext) ac).close();
    }

}
