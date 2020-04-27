package com.lvqz.spring.lab1.service.serviceImpl;

import com.lvqz.spring.lab1.dao.IAccountDao;
import com.lvqz.spring.lab1.factory.BeanFactory;
import com.lvqz.spring.lab1.service.IAccountService;

/**
 * @author: 吕秋圳
 * @date: 2020/4/27
 * @time: 21:48
 */
public class AccountServiceImpl implements IAccountService {

//    private IAccountDao ad = new AccountDaoImpl();
      //通过工厂创建bean对象
      private IAccountDao ad = (IAccountDao) BeanFactory.getBean("accountDao");
    //实现保存账户方法
    public void saveAccount() {
        ad.saveAccount();
    }
}
