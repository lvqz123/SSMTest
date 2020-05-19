package com.lvqz.spring.lab09.dao;

import com.lvqz.spring.lab09.domain.Account;

import java.util.List;

/**
 * @author: lvqz
 * @date: 2020/4/29
 * @time: 15:20
 */
public interface IAccountDao {

    //查询所有账户信息
    List<Account> findAllAccount();

    //查询单个账户信息
    Account findOneAccount(Integer accoutId);

    //新加一条账户信息
    void insertAccount(Account account);

    //修改一条账户信息
    void updateAccount(Account account);

    //删除一条账户信息
    void deleteAccount(Integer accountId);

    //根据名称获取账户信息
    Account findAccountByName(String accountName);

}
