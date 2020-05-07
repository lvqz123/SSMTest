package com.lvqz.spring.lab9.service.Impl;

import com.lvqz.spring.lab9.dao.IAccountDao;
import com.lvqz.spring.lab9.domain.Account;
import com.lvqz.spring.lab9.service.IAccountService;
import com.lvqz.spring.lab9.utils.TransactionManager;

import java.util.List;

/**
 * @author: lvqz
 * @date: 2020/4/29
 * @time: 15:21
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    //通过代理对象来控制事务，这里就不需要了
   /* //获取事务管理对象
    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }*/

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
            return accountDao.findAllAccount();
    }

    public Account findOneAccount(Integer accoutId) {
            return accountDao.findOneAccount(accoutId);
    }

    public void insertAccount(Account account) {
            accountDao.insertAccount(account);
    }

    public void updateAccount(Account account) {
            accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {
            accountDao.deleteAccount(accountId);
    }

    public void transferAccount(String sourceName, String targetName, Float money) {
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
//            int i = 1/0;

            //2.6更新收钱账户
            accountDao.updateAccount(target);
    }
}
