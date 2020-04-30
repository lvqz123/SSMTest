package com.lvqz.test;

import com.lvqz.spring.lab7.domain.Account;
import com.lvqz.spring.lab7.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author: lvqz
 * @date: 2020/4/29
 * @time: 16:23
 */
public class AccountServiceTest {

    @Test
    public void testFindAll() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = (IAccountService) ac.getBean("accountService");
        List<Account> allAccount = accountService.findAllAccount();
        for (Account account : allAccount) {
            System.out.println(account);
        }

    }

    @Test
    public void testFindOne() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = (IAccountService) ac.getBean("accountService");
        Account oneAccount = accountService.findOneAccount(1);
        System.out.println(oneAccount);
    }

    @Test
    public void testInsert() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = (IAccountService) ac.getBean("accountService");
        Account account = new Account();
        account.setName("张三");
        account.setMoney(1234f);
        accountService.insertAccount(account);
    }

    @Test
    public void testUpdate() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = (IAccountService) ac.getBean("accountService");
        Account account = accountService.findOneAccount(4);
        account.setName("test");
        accountService.updateAccount(account);
    }

    @Test
    public void testDelete() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = (IAccountService) ac.getBean("accountService");
        accountService.deleteAccount(4);
    }

}
