package com.lvqz.spring.lab1.service.serviceImpl;

import com.lvqz.spring.lab1.dao.IAccountDao;
import com.lvqz.spring.lab1.factory.BeanFactory;
import com.lvqz.spring.lab1.service.IAccountService;

/**
 * @author: ������
 * @date: 2020/4/27
 * @time: 21:48
 */
public class AccountServiceImpl implements IAccountService {

//    private IAccountDao ad = new AccountDaoImpl();
      //ͨ����������bean����
      private IAccountDao ad = (IAccountDao) BeanFactory.getBean("accountDao");
    //ʵ�ֱ����˻�����
    public void saveAccount() {
        ad.saveAccount();
    }
}
