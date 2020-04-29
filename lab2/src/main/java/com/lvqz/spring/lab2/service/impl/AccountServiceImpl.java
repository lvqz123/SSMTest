package com.lvqz.spring.lab2.service.impl;

import com.lvqz.spring.lab2.dao.IAccountDao;
import com.lvqz.spring.lab2.dao.impl.AccountDaoImpl;
import com.lvqz.spring.lab2.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: lvqz
 * @date: 2020/4/27
 * @time: 21:48
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao ad;
//    ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//     IAccountDao ad = (IAccountDao) new ClassPathXmlApplicationContext("bean.xml").getBean("accountDao");


    public void setAd(IAccountDao ad) {
        this.ad = ad;
    }

    public AccountServiceImpl(){

        System.out.println("对象创建了!");

    }

    //实现保存账户方法
    public void saveAccount() {
        ad.saveAccount();
    }
}
