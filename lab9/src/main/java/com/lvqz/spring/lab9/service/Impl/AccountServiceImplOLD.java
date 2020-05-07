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
public class AccountServiceImplOLD implements IAccountService {

    private IAccountDao accountDao;

    //获取事务管理对象
    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
        try {
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            List<Account> allAccount = accountDao.findAllAccount();
            //3.提交事务
            transactionManager.commit();
            //4.返回结果
            return allAccount;
        } catch (Exception e) {
            //5.回滚操作
            transactionManager.rollback();
            throw new RuntimeException(e);
        } finally {
            //6.释放连接
            transactionManager.release();
        }
    }

    public Account findOneAccount(Integer accoutId) {
        try {
        //1.开启事务
        transactionManager.beginTransaction();
        //2.执行操作
        Account account = accountDao.findOneAccount(accoutId);
        //3.提交事务
        transactionManager.commit();
        //4.返回结果
        return account;
        } catch (Exception e) {
            //5.回滚操作
            transactionManager.rollback();
            throw new RuntimeException(e);
        } finally {
            //6.释放连接
            transactionManager.release();
        }
    }

    public void insertAccount(Account account) {
        try {
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            accountDao.insertAccount(account);
            //3.提交事务
            transactionManager.commit();
        } catch (Exception e) {
            //5.回滚操作
            transactionManager.rollback();
            throw new RuntimeException(e);
        } finally {
            //6.释放连接
            transactionManager.release();
        }

    }

    public void updateAccount(Account account) {
        try {
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            accountDao.updateAccount(account);
            //3.提交事务
            transactionManager.commit();
        } catch (Exception e) {
            //5.回滚操作
            transactionManager.rollback();
            throw new RuntimeException(e);
        } finally {
            //6.释放连接
            transactionManager.release();
        }

    }

    public void deleteAccount(Integer accountId) {
        try {
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            accountDao.deleteAccount(accountId);
            //3.提交事务
            transactionManager.commit();
        } catch (Exception e) {
            //5.回滚操作
            transactionManager.rollback();
            throw new RuntimeException(e);
        } finally {
            //6.释放连接
            transactionManager.release();
        }

    }

    public void transferAccount(String sourceName, String targetName, Float money) {

        try {
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作

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

            //3.提交事务
            transactionManager.commit();
        } catch (Exception e) {
            //5.回滚操作
            transactionManager.rollback();
            throw new RuntimeException(e);
        } finally {
            //6.释放连接
            transactionManager.release();
        }


    }
}
