package com.lvqz.spring.lab4.service.impl;

import com.lvqz.spring.lab4.service.IAccountService;

import java.util.*;

/**
 * @author: lvqz
 * @date: 2020/4/27
 * @time: 21:48
 */
public class AccountServiceImpl3 implements IAccountService {

    private String[] myStrs;
    private List<String> myList;
    private Set<String> mySet;
    private Map<String,String> myMap;
    private Properties props;



    public void setMyStrs(String[] myStrs) {
        this.myStrs = myStrs;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setProps(Properties props) {
        this.props = props;
    }
    //实现保存账户方法
    public void saveAccount() {
        System.out.println(Arrays.toString(myStrs));
        System.out.println(myList);
        System.out.println(mySet);
        System.out.println(myMap);
        System.out.println(props);
    }


}
