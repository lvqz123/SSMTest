package com.lvqz.test;

import com.lvqz.mybatis.dao.IUserDao;
import com.lvqz.mybatis.dao.impl.UserDaoImpl;
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

    public static void main(String [] args) {
        //1.读取配置文件
        InputStream in = null;
        SqlSession sqlSession = null;
        try {
            in = Resources.getResourceAsStream("mybatis.xml");
            //2.创建SQLSessionFactory的构建者对象
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //3.创建SqlSessionFactory对象
            SqlSessionFactory factory = builder.build(in);
            //4.使用SqlSessionFactory创建UserDaoImpl对象
            IUserDao userDao = new UserDaoImpl(factory);
            //5.调用IUserDao的方法
            List<User> users = userDao.findAllUser();
            for (User user : users) {
                System.out.println(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if( in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }

}
