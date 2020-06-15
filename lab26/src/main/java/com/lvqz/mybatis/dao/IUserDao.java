package com.lvqz.mybatis.dao;

import com.lvqz.mybatis.domain.User;

import java.util.List;

/**
 * @author: lvqz
 * @date: 2020/5/26
 * @time: 17:14
 */
public interface IUserDao {

    /**
     * 查询所有
     * @return
     */
    List<User> findAllUser();

    /**
     * 根据id查询一条
     * @param id 用户id
     * @return
     */
    User findById(Integer id);

    /**
     * 根据名字进行模糊查询
     * @param username 姓名
     * @return
     */
    List<User> findByName(String username);



}
