package com.lvqz.lab15.jdbctemplate;

import com.lvqz.lab15.dao.IAccountDao;
import com.lvqz.lab15.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author: lvqz
 * @date: 2020/5/20
 * @time: 15:29
 */
public class JdbcTemplateDemo03 {

    public static void main(String [] args){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountDao accountDao = ac.getBean("accountDao",IAccountDao.class);
        List<Account> accounts = accountDao.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
       /* IAccountDao accountDao02 = ac.getBean("accountDao02",IAccountDao.class);
        List<Account> accounts = accountDao02.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }*/
    }

}
