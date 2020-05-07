package com.lvqz.test;


import com.lvqz.spring.lab9.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: lvqz
 * @date: 2020/4/29
 * @time: 16:23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    //可以看到 如果不加Qualifier的话，会报错，说明bean中配置了两个以上的IAccountService类型的bean
    @Autowired
    @Qualifier("proxyService")
    private IAccountService as;

    @Test
    public void transfer() {
        as.transferAccount("aaa","bbb",100f);
    }
}
