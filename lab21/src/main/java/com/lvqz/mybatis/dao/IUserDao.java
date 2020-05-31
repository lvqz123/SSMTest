package com.lvqz.mybatis.dao;

import com.lvqz.mybatis.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: lvqz
 * @date: 2020/5/26
 * @time: 17:14
 */
public interface IUserDao {

    //查询
    @Select("select * from user")
    List<User> findAllUser();

}
