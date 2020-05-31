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
        //ʹ�ù�������session����
        SqlSession session = factory.openSession();
        //ʹ��sessionִ�в�ѯ���з���
        List<User> users = session.selectList("com.lvqz.mybatis.dao.IUserDao.findAllUser");
        return users;
    }
}
