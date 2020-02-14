package com.ultrapower.alert.alert.core.gather.entity;

import java.util.Date;
import java.util.StringJoiner;

/**
 * @ClassName AlertRecord
 * @Description 告警记录
 * @Author wangzhenguang
 * @Date 2020/2/14
 * @Version 1.0
 */
public class AlertRecord {

    /**
     * message最大长度
     */
    public static final int MAX_LEN = 500;

    /**
     * id
     */
    private String id;

    /**
     * host
     */
    private String host;

    /**
     * 应用名称
     */
    private String appName;

    /**
     * 告警关键字
     */
    private String term;

    /**
     * 原始消息
     */
    private String message;

    /**
     * es索引
     */
    private String esIdx;

    /**
     * 原始消息的生成时间
     */
    private Date msgTime;

    /**
     * 告警记录的插入时间
     */
    private Date insertTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        if (message != null && message.length() > MAX_LEN) {
            message = message.substring(0, MAX_LEN);
        }
        this.message = message;
    }

    public String getEsIdx() {
        return esIdx;
    }

    public void setEsIdx(String esIdx) {
        this.esIdx = esIdx;
    }

    public Date getMsgTime() {
        return msgTime;
    }

    public void setMsgTime(Date msgTime) {
        this.msgTime = msgTime;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AlertRecord.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("host='" + host + "'")
                .add("appName='" + appName + "'")
                .add("term='" + term + "'")
                .add("message='" + message + "'")
                .add("esIdx='" + esIdx + "'")
                .add("msgTime=" + msgTime)
                .add("insertTime=" + insertTime)
                .toString();
    }
}
