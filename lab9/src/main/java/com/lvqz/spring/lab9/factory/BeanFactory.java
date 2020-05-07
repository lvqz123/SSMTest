package com.lvqz.spring.lab9.factory;

import com.lvqz.spring.lab9.service.IAccountService;
import com.lvqz.spring.lab9.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: lvqz
 * @date: 2020/5/7
 * @time: 16:16
 *
 * 用于创建Service代理对象的工厂
 *
 */
public class BeanFactory {

    private IAccountService accountService;

    private TransactionManager transactionManager;

    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public IAccountService getAccountService(){
        IAccountService proxyInstance=(IAccountService)Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object returnValue = null;
                try {
                    //1.开启事务
                    transactionManager.beginTransaction();
                    //2.执行操作
                    returnValue = method.invoke(accountService,args);
                    //3.提交事务
                    transactionManager.commit();
                    //4.返回结果
                    return returnValue;
                } catch (Exception e) {
                    //5.回滚操作
                    transactionManager.rollback();
                    throw new RuntimeException(e);
                } finally {
                    //6.释放连接
                    transactionManager.release();
                }
            }
        });
        return proxyInstance;
    }

}
