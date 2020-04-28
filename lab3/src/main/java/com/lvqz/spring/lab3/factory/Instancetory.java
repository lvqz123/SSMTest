package com.lvqz.spring.lab3.factory;

import com.lvqz.spring.lab3.service.IAccountService;
import com.lvqz.spring.lab3.service.impl.AccountServiceImpl;

/**
 * @author: lvqz
 * @date: 2020/4/28
 * @time: 14:58
 */
public class Instancetory {

    public IAccountService getAccountService(){

        return new AccountServiceImpl();

    }

}
