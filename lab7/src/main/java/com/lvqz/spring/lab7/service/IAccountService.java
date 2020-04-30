package com.lvqz.spring.lab7.service;

import com.lvqz.spring.lab7.domain.Account;

import java.util.List;

/**
 * @author: lvqz
 * @date: 2020/4/29
 * @time: 15:20
 */
public interface IAccountService {

    //查询所有账户信息
    public List<Account> findAllAccount();

    //查询单个账户信息
    public Account findOneAccount(Integer accoutId);

    //新加一条账户信息
    public void insertAccount(Account account);

    //修改一条账户信息
    public  void updateAccount(Account account);

    //删除一条账户信息
    public void deleteAccount(Integer accountId);

}
