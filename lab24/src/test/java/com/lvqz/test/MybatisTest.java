package com.lvqz.test;

import com.lvqz.mybatis.dao.IUserDao;
import com.lvqz.mybatis.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author: lvqz
 * @date: 2020/5/27
 * @time: 17:20
 */
public class MybatisTest {

    //1.读取配置文件
    InputStream in = null;
    SqlSession sqlSession = null;
    IUserDao userDao = null;

    @Before
    public void init(){
        try {
            in = Resources.getResourceAsStream("mybatis.xml");
            //2.创建SQLSessionFactory的构建者对象
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //3.创建SqlSessionFactory对象
            SqlSessionFactory factory = builder.build(in);
            //4.使用SqlSession创建SqlSession对象
            sqlSession = factory.openSession();
            //5.使用SqlSession创建Dao对象
            userDao = sqlSession.getMapper(IUserDao.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void commit(){
        sqlSession.commit();
        sqlSession.close();
        if( in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void findAllUser() {
        List<User> users = userDao.findAllUser();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void findUserById() {
        User user = userDao.findById(55);
        System.out.println(user);
    }

    @Test
    public void findUserByName(){
        List<User> users = userDao.findByName("%王%");
//        List<User> users = userDao.findByName("王");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setUserName("无敌");
        user.setUserAddress("朝阳门");
        user.setUserSex("男");
        user.setUserBirthday(new Date());
        System.out.println("保存方法之前：" + user);
        userDao.saveUser(user);
        System.out.println("保存方法之后：" + user);

    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setUserId(55);
        user.setUserName("无敌2");
        user.setUserAddress("崇文门");
        user.setUserSex("女");
        user.setUserBirthday(new Date());

        userDao.updateUser(user);
    }

    @Test
    public void testDeleteUser() {
        userDao.deleteUser(55);
    }

    @Test
    public void testFindTotal() {
        int total = userDao.findTotal();
        System.out.println(total);
    }
}
