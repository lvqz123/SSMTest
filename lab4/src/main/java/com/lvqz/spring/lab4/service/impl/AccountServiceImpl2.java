package com.lvqz.spring.lab4.service.impl;

import com.lvqz.spring.lab4.service.IAccountService;

import java.util.Date;

/**
 * @author: lvqz
 * @date: 2020/4/27
 * @time: 21:48
 */
public class AccountServiceImpl2 implements IAccountService {

    private String name;
    private Integer age;
    private Date birth;


    public AccountServiceImpl2(){
        System.out.println("对象创建了!");
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }


    //实现保存账户方法
    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了");
    }

    @Override
    public String toString() {
        return "AccountServiceImpl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                '}';
    }
}
