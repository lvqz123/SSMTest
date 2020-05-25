package com.lvqz.lab19.service.impl;

import com.lvqz.lab19.dao.IAccountDao;
import com.lvqz.lab19.domain.Account;
import com.lvqz.lab19.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author: lvqz
 * @date: 2020/4/29
 * @time: 15:21
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    @Autowired
    public TransactionTemplate transactionTemplate;



    public Account findAccountById(final Integer accoutId) {
       return transactionTemplate.execute(new TransactionCallback<Account>() {
            public Account doInTransaction(TransactionStatus transactionStatus) {
                return accountDao.findAccountById(accoutId);
            }
        });
    }


    public void transfer(final String sourceName, final String targetName, final Float money) {
        //编程式事务需要调用transactionTemplate.execute方法 并且每一个需要事务的方法都需要加上这个方法,代码冗余严重
        transactionTemplate.execute(new TransactionCallback<Object>() {
            public Object doInTransaction(TransactionStatus transactionStatus) {
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
                return null;
            }
        });


    }
}
