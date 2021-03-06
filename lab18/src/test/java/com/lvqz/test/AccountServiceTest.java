package com.lvqz.test;


import com.lvqz.lab18.config.SpringConfig;
import com.lvqz.lab18.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: lvqz
 * @date: 2020/4/29
 * @time: 16:23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class AccountServiceTest {
    @Autowired
    private IAccountService as;

    @Test
    public void transfer() {
        as.transfer("aaa","bbb",100f);
    }
}
