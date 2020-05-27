package com.lvqz.test;

import com.lvqz.mybatis.dao.IUserDao;
import com.lvqz.mybatis.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author: lvqz
 * @date: 2020/5/27
 * @time: 17:20
 */
public class MybatisTest {

    public static void main(String [] args) throws IOException {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        //2.创建SQLSessionFactory的构建者对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3.创建SqlSessionFactory对象
        SqlSessionFactory factory = builder.build(in);
        //4.使用SqlSession创建SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //5.使用SqlSession创建Dao对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        //6.调用IUserDao的方法
        List<User> users = userDao.findAllUser();
        for (User user : users) {
            System.out.println(user);
        }

    }

}
