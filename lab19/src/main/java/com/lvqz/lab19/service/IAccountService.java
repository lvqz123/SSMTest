package com.lvqz.lab19.service;

import com.lvqz.lab19.domain.Account;

/**
 * @author: 61681
 * @date: 2020/5/20
 * @time: 22:21
 */
public interface IAccountService {

    Account findAccountById(Integer accountId);


    /**
     *
     * @param sourceName ת���˻�
     * @param targetName ת���˻�
     * @param money  ת�˽��
     */
    void transfer(String sourceName,String targetName,Float money);



}
