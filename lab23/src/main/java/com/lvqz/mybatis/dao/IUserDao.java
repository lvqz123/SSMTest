package com.lvqz.mybatis.dao;

import com.lvqz.mybatis.domain.User;

import java.util.List;

/**
 * @author: lvqz
 * @date: 2020/5/26
 * @time: 17:14
 */
public interface IUserDao {

    //查询
    List<User> findAllUser();

}
