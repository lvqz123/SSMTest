package com.lvqz.mybatis.mybatisUtil.cfg;

/**
 * @author: lvqz
 * @date: 2020/5/31
 * @time: 21:53
 *
 * ���ڷ�װִ�е�SQL���ͽ�����͵�ȫ�޶�����
 *
 */
public class Mapper {

    /**
     * SQL���
     */
    private String queryString;
    /**
     * ȫ�޶�����
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
