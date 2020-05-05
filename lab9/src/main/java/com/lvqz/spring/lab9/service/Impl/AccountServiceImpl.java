package com.lvqz.spring.lab9.service.Impl;

import com.lvqz.spring.lab9.dao.IAccountDao;
import com.lvqz.spring.lab9.domain.Account;
import com.lvqz.spring.lab9.service.IAccountService;
import com.lvqz.spring.lab9.utils.TransactionManager;

import java.util.List;

/**
 * @author: lvqz
 * @date: 2020/4/29
 * @time: 15:21
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    //��ȡ����������
    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
        try {
            //1.��������
            transactionManager.beginTransaction();
            //2.ִ�в���
            List<Account> allAccount = accountDao.findAllAccount();
            //3.�ύ����
            transactionManager.commit();
            //4.���ؽ��
            return allAccount;
        } catch (Exception e) {
            //5.�ع�����
            transactionManager.rollback();
            throw new RuntimeException(e);
        } finally {
            //6.�ͷ�����
            transactionManager.release();
        }
    }

    public Account findOneAccount(Integer accoutId) {
        try {
        //1.��������
        transactionManager.beginTransaction();
        //2.ִ�в���
        Account account = accountDao.findOneAccount(accoutId);
        //3.�ύ����
        transactionManager.commit();
        //4.���ؽ��
        return account;
        } catch (Exception e) {
            //5.�ع�����
            transactionManager.rollback();
            throw new RuntimeException(e);
        } finally {
            //6.�ͷ�����
            transactionManager.release();
        }
    }

    public void insertAccount(Account account) {
        try {
            //1.��������
            transactionManager.beginTransaction();
            //2.ִ�в���
            accountDao.insertAccount(account);
            //3.�ύ����
            transactionManager.commit();
        } catch (Exception e) {
            //5.�ع�����
            transactionManager.rollback();
            throw new RuntimeException(e);
        } finally {
            //6.�ͷ�����
            transactionManager.release();
        }

    }

    public void updateAccount(Account account) {
        try {
            //1.��������
            transactionManager.beginTransaction();
            //2.ִ�в���
            accountDao.updateAccount(account);
            //3.�ύ����
            transactionManager.commit();
        } catch (Exception e) {
            //5.�ع�����
            transactionManager.rollback();
            throw new RuntimeException(e);
        } finally {
            //6.�ͷ�����
            transactionManager.release();
        }

    }

    public void deleteAccount(Integer accountId) {
        try {
            //1.��������
            transactionManager.beginTransaction();
            //2.ִ�в���
            accountDao.deleteAccount(accountId);
            //3.�ύ����
            transactionManager.commit();
        } catch (Exception e) {
            //5.�ع�����
            transactionManager.rollback();
            throw new RuntimeException(e);
        } finally {
            //6.�ͷ�����
            transactionManager.release();
        }

    }

    public void transferAccount(String sourceName, String targetName, Float money) {

        try {
            //1.��������
            transactionManager.beginTransaction();
            //2.ִ�в���

            //2.1�������ֻ�ȡת���˻�
            Account source = accountDao.findAccountByName(sourceName);
            //2.2�������ֻ�ȡ��Ǯ�˻�
            Account target = accountDao.findAccountByName(targetName);
            //2.3ת���˻���ȥǮ
            source.setMoney(source.getMoney() - money);
            //2.4��Ǯ�˻���Ǯ
            target.setMoney(target.getMoney()+ money);
            //2.5����ת���˻�
            accountDao.updateAccount(source);

            //�����ڸ����˻���ʱ��������⣬ģ��һ�����ϵ�����;����(�����͵���aaaǮ���ˣ�����bbbҲû�յ�Ǯ �Ѿ������¹��ˡ�)
            int i = 1/0;

            //2.6������Ǯ�˻�
            accountDao.updateAccount(target);

            //3.�ύ����
            transactionManager.commit();
        } catch (Exception e) {
            //5.�ع�����
            transactionManager.rollback();
            throw new RuntimeException(e);
        } finally {
            //6.�ͷ�����
            transactionManager.release();
        }


    }
}
