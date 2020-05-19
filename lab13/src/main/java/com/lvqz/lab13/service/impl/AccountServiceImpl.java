package com.lvqz.lab13.service.impl;

import com.lvqz.lab13.service.IAccountService;
import org.springframework.stereotype.Service;

/**
 * @author: lvqz
 * @date: 2020/5/18
 * @time: 16:13
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    public void saveAccount() {
        System.out.println("执行了保存账户方法");
//        int i = 1/0;
    }

    public void updateAccount(int i) {
        System.out.println("执行了更改账户方法");
    }

    public int deleteAccout() {
        System.out.println("执行了删除账户方法");
        return 0;
    }
}
