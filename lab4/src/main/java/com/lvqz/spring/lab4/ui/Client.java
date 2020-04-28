package com.lvqz.spring.lab4.ui;

import com.lvqz.spring.lab4.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
//        获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        根据id获取Bean对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
        System.out.println(as.toString());

        IAccountService as1 = (IAccountService) ac.getBean("accountService2");
        System.out.println(as1.toString());

        IAccountService as2 = (IAccountService) ac.getBean("accountService3");
        as2.saveAccount();
    }

}
