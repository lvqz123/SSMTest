package com.lvqz.mybatis.mybatisUtil.cfg;

/**
 * @author: lvqz
 * @date: 2020/5/31
 * @time: 21:53
 *
 * 用于封装执行的SQL语句和结果类型的全限定类名
 *
 */
public class Mapper {

    /**
     * SQL语句
     */
    private String queryString;
    /**
     * 全限定类名
     */
    private String resultType;

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
