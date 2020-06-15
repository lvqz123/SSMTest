package com.lvqz.mybatis.dao;

import com.lvqz.mybatis.domain.QueryVo;
import com.lvqz.mybatis.domain.User;

import java.util.List;

/**
 * @author: lvqz
 * @date: 2020/5/26
 * @time: 17:14
 */
public interface IUserDao {

    /**
     * 查询所有
     * @return
     */
    List<User> findAllUser();

    /**
     * 根据id查询一条
     * @param id 用户id
     * @return
     */
    User findById(Integer id);

    /**
     * 根据名字进行模糊查询
     * @param username 姓名
     * @return
     */
    List<User> findByName(String username);

    /**
     * 保存用户
     * @param user 用户属性
     */
    void saveUser(User user);

    /**
     * 更改用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除用户根据Id
     * @param id
     */
    void deleteUser(Integer id);

    /**
     * 查询总条数
     * @return
     */
    int findTotal();

    /**
     * 根据对象查询相关内容
     * @param queryVo queryVo对象
     * @return
     */
    List<User> findByQueryVo(QueryVo queryVo);


    /**
     * 根据条件动态查询数据
     * @param user 传入的user参数
     * @return
     */
    List<User> findByCondition(User user);


    /**
     * 根据id集合，查询user数据
     * 目的达到是这个语句   select * from user where id in (?,?,?,?)
     * @param vo
     * @return
     */
    List<User> findByIds(QueryVo vo);



}
