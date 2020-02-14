package com.ultrapower.alert.alert.core.gather.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @ClassName DateTimeUtil
 * @Description 日期时间工具类
 * @Author wangzhenguang
 * @Date 2020/2/14
 * @Version 1.0
 */
public abstract class DateTimeUtil {

    /**
     * 将UTC时间字符串转成本地Date
     *
     * @param utcTime UTC时间字符串
     * @return 本地Date对象
     * @throws ParseException
     */
    public static Date parseUTC(String utcTime) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return dateFormat.parse(utcTime);
    }

}
