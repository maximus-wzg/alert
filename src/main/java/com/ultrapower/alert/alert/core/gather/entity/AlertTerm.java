package com.ultrapower.alert.alert.core.gather.entity;

import java.util.StringJoiner;

/**
 * @ClassName AlertTerm
 * @Description 告警关键字
 * @Author wangzhenguang
 * @Date 2020/2/14
 * @Version 1.0
 */
public class AlertTerm {

    private int id;

    private String term;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AlertTerm.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("term='" + term + "'")
                .toString();
    }
}
