package com.lvqz.lab18.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author: lvqz
 * @date: 2020/5/21
 * @time: 9:58
 */
@Configuration
@ComponentScan(value = "com.lvqz.lab18")
@PropertySource(value = "jdbc.properties")
@EnableTransactionManagement
public class SpringConfig {

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    /**
     * 创建JdbcTemplate的Bean
     *
     * @param dataSource
     * @return
     */
    @Bean(name = "jdbcTemplate")
    public JdbcTemplate createJdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }


    /**
     * 创建DataSource的Bean
     *
     * @return
     */
    @Bean(name = "dataSource")
    public DataSource createDataSource(){
        DriverManagerDataSource driverManager = new DriverManagerDataSource();
        driverManager.setDriverClassName(driver);
        driverManager.setUrl(url);
        driverManager.setUsername(username);
        driverManager.setPassword(password);
        return driverManager;
    }

    /**
     * 创建事务管理器的Bean
     * @param dataSource
     * @return
     */
    @Bean(name = "transactionManager")
    public PlatformTransactionManager createDataSourceTransactionManager(DataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);
        return dataSourceTransactionManager;
    }


}
