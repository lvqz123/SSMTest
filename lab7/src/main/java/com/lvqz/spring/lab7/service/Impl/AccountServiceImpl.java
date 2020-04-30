package com.lvqz.spring.lab7.service.Impl;

import com.lvqz.spring.lab7.dao.IAccountDao;
import com.lvqz.spring.lab7.domain.Account;
import com.lvqz.spring.lab7.service.IAccountService;
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
