package com.lvqz.spring.lab3.service.impl;

import com.lvqz.spring.lab3.service.IAccountService;

/**
 * @author: lvqz
 * @date: 2020/4/27
 * @time: 21:48
 */
public class AccountServiceImpl implements IAccountService {


    /*public AccountServiceImpl(String name){
        System.out.println("对象创建了!");
    }*/

    public AccountServiceImpl(){
        System.out.println("对象创建了!");
    }

    //实现保存账户方法
    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了");
    }

    public void init(){
        System.out.println("对象初始化了！");
    }

    public void destory(){
        System.out.println("对象销毁了！");
    }

}
