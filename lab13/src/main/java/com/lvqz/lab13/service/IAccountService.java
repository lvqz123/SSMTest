package com.lvqz.lab13.service;

/**
 * @author: lvqz
 * @date: 2020/5/18
 * @time: 16:10
 */
public interface IAccountService {

    /**
     * 模拟保存账户
     */
    void saveAccount();

    /**
     * 模拟更改用户
     * @param i
     */
    void updateAccount(int i);

    /**
     * 模拟删除用户
     * @return
     */
    int deleteAccout();

}
