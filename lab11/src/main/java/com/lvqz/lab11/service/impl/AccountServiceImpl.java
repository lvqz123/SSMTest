package com.lvqz.lab11.service.impl;

import com.lvqz.lab11.service.IAccountService;

/**
 * @author: lvqz
 * @date: 2020/5/18
 * @time: 16:13
 */
public class AccountServiceImpl implements IAccountService {

    public void saveAccount() {
        System.out.println("执行了保存账户方法");
    }

    public void updateAccount(int i) {
        System.out.println("执行了更改账户方法");
    }

    public int deleteAccout() {
        System.out.println("执行了删除账户方法");
        return 0;
    }
}
