package com.lvqz.test;

import config.SpringConfiguration;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: lvqz
 * @date: 2020/4/30
 * @time: 16:25
 *
 * 默认是单例，多例需要在Bean加上@Scope注解
 *
 */
public class QueryRunnerTest {

    @Test
    public void testScope() {
        //1.获取容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.测试是否单例
        QueryRunner queryRunner = (QueryRunner) ac.getBean("runner");
        QueryRunner queryRunner2 = (QueryRunner) ac.getBean("runner");
        System.out.println(queryRunner == queryRunner2);


    }
}
