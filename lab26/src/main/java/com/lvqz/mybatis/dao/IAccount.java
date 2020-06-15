package com.lvqz.mybatis.dao;

import com.lvqz.mybatis.domain.Account;

import java.util.List;

/**
 * @author: lvqz
 * @date: 2020/6/15
 * @time: 17:26
 */
public interface IAccount {

    /**
     * 查询所有账户
     * @return
     */
    List<Account> findAll();
}
