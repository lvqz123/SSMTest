package com.lvqz.spring.lab4.factory;

import com.lvqz.spring.lab4.service.IAccountService;
import com.lvqz.spring.lab4.service.impl.AccountServiceImpl;

/**
 * @author: lvqz
 * @date: 2020/4/28
 * @time: 14:58
 */
public class StaticInstancetory {

    public static IAccountService getAccountService(){

        return new AccountServiceImpl();

    }

}
