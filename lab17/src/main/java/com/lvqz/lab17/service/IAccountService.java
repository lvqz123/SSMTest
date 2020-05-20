package com.lvqz.lab17.service;

import com.lvqz.lab17.domain.Account;

/**
 * @author: 61681
 * @date: 2020/5/20
 * @time: 22:21
 */
public interface IAccountService {

    Account findAccountById(Integer accountId);


    /**
     *
     * @param sourceName 转出账户
     * @param targetName 转入账户
     * @param money  转账金额
     */
    void transfer(String sourceName,String targetName,Float money);



}
