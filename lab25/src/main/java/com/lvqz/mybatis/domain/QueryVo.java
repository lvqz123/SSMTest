package com.lvqz.mybatis.domain;

import java.util.List;

/**
 * @author: lvqz
 * @date: 2020/6/15
 * @time: 15:21
 */
public class QueryVo {

    private User user;

    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
