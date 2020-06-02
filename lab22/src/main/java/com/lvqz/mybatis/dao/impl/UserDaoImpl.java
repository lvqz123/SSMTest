package com.lvqz.mybatis.dao.impl;

import com.lvqz.mybatis.dao.IUserDao;
import com.lvqz.mybatis.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author: lvqz
 * @date: 2020/5/31
 * @time: 21:13
 */
public class UserDaoImpl implements IUserDao {

    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    public List<User> findAllUser() {
        //使用工厂创建session对象
        SqlSession session = factory.openSession();
        //使用session执行查询所有方法
        List<User> users = session.selectList("com.lvqz.mybatis.dao.IUserDao.findAllUser");
        return users;
    }
}
