package com.lvqz.lab16.dao;

import com.lvqz.lab16.domain.Account;

import java.util.List;

/**
 * @author: lvqz
 * @date: 2020/5/20
 * @time: 12:02
 */
public interface IAccountDao {

    List<Account> findAllAccount();

    Account findAccountById(Integer accountId);

    Account findAccountByName(String name);

    void updateAccount(Account account);

}
