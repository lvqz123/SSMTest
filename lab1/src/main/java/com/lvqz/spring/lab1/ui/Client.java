package com.lvqz.spring.lab1.ui;

import com.lvqz.spring.lab1.factory.BeanFactory;
import com.lvqz.spring.lab1.service.IAccountService;

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
        for (int i = 0; i < 5; i++) {
            IAccountService as = (IAccountService) BeanFactory.getBean("accountService");
            System.out.println(as);
        }

//        as.saveAccount();
    }

}
