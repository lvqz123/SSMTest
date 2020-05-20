package com.lvqz.lab16.service.impl;

import com.lvqz.lab16.dao.IAccountDao;
import com.lvqz.lab16.domain.Account;
import com.lvqz.lab16.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: lvqz
 * @date: 2020/4/29
 * @time: 15:21
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;


    public Account findAccountById(Integer accoutId) {
            return accountDao.findAccountById(accoutId);
    }


    public void transfer(String sourceName, String targetName, Float money) {
            //2.1根据名字获取转账账户
            Account source = accountDao.findAccountByName(sourceName);
            //2.2根据名字获取收钱账户
            Account target = accountDao.findAccountByName(targetName);
            //2.3转账账户减去钱
            source.setMoney(source.getMoney() - money);
            //2.4收钱账户加钱
            target.setMoney(target.getMoney()+ money);
            //2.5更新转账账户
            accountDao.updateAccount(source);
            //假如在更新账户的时候出现问题，模拟一个故障导致中途报错(这样就导致aaa钱少了，但是bbb也没收到钱 已经属于事故了。)
            int i = 1/0;

            //2.6更新收钱账户
            accountDao.updateAccount(target);
    }
}
