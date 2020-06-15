package com.lvqz.test;

import com.lvqz.mybatis.dao.IAccount;
import com.lvqz.mybatis.dao.IUserDao;
import com.lvqz.mybatis.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author: lvqz
 * @date: 2020/6/15
 * @time: 17:23
 */
public class AccountTest {

    //1.读取配置文件
    InputStream in = null;
    SqlSession sqlSession = null;
    IAccount accountDao = null;

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
            accountDao = sqlSession.getMapper(IAccount.class);
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
    public void testFindAll() {
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println(account);

        }
    }
}
