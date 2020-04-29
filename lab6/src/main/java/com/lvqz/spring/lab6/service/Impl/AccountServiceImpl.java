package com.lvqz.spring.lab6.service.Impl;

import com.lvqz.spring.lab6.dao.IAccountDao;
import com.lvqz.spring.lab6.domain.Account;
import com.lvqz.spring.lab6.service.IAccountService;

import java.util.List;

/**
 * @author: lvqz
 * @date: 2020/4/29
 * @time: 15:21
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

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
}
