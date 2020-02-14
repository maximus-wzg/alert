package com.ultrapower.alert.alert.core.gather.mapper;

import com.ultrapower.alert.alert.core.gather.entity.AlertRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName AlertRecordMapper
 * @Description 告警记录
 * @Author wangzhenguang
 * @Date 2020/2/14
 * @Version 1.0
 */
@Mapper
public interface AlertRecordMapper {

    @Insert("insert into t_alert_record (id, host, app_name, term, message, es_idx, msg_time, insert_time) values " +
            " (#{id, jdbcType=VARCHAR}, #{host, jdbcType=VARCHAR}, #{appName, jdbcType=VARCHAR}, #{term, jdbcType=VARCHAR}," +
            " #{message, jdbcType=VARCHAR}, #{esIdx, jdbcType=VARCHAR}, #{msgTime, jdbcType=TIMESTAMP}, #{insertTime, jdbcType=TIMESTAMP}) ")
    int save(AlertRecord record);

}
