package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

/**
 * @author: lvqz
 * @date: 2020/4/30
 * @time: 15:56
 */

public class JdbcConfig {

    /**
     * 配置Driver类
     */
    @Value("${jdbc.driver}")
    private String driver;

    /**
     * 配置url
     */
    @Value("${jdbc.url}")
    private String url;

    /**
     * 配置username
     */
    @Value("${jdbc.user}")
    private String username;

    /**
     * 配置password
     */
    @Value("${jdbc.password}")
    private String password;
    
    /**
     * 用于创建一个QueryRunner对象
     * @param dataSource
     * @return
     */
    @Bean(name = "runner")
    @Scope(value = "prototype")
    public QueryRunner creatQueryRunner(@Qualifier(value = "ds2") DataSource dataSource){
        return new QueryRunner(dataSource);
    }

    @Bean(name = "ds1")
    public DataSource creatDataSource(){
        ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(username);
            ds.setPassword(password);
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
        return ds;
    }

    /**
     * 用于测试@Bean当有容器中多个Bean的时候如何注入的（事实上和Autowired一样）
     * @return
     */
    @Bean(name = "ds2")
    public DataSource creatDataSource2(){
        ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            ds.setDriverClass(driver);
            ds.setJdbcUrl("jdbc:mysql://47.95.239.50:3306/ssmTestBeanTest?useUnicode=true&characterEncoding=utf8");
            ds.setUser(username);
            ds.setPassword(password);
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
        return ds;
    }


}
