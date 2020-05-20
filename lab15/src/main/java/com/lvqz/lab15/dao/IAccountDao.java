package com.lvqz.lab15.dao;

import com.lvqz.lab15.domain.Account;

import java.util.List;

/**
 * @author: lvqz
 * @date: 2020/5/20
 * @time: 12:02
 */
public interface IAccountDao {

    List<Account> findAllAccount();

    Account findOneAccountById(int id);

    void updateAccount(Account account);

}
