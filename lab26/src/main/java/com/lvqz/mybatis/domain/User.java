package com.lvqz.mybatis.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: lvqz
 * @date: 2020/5/26
 * @time: 16:44
 */
public class User implements Serializable {

    private Integer id;
    private String name;
    private Date birthday;
    private String sex;
    private String address;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
