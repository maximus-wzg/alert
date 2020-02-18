package com.ultrapower.alert.alert.core.gather.mapper;

import com.ultrapower.alert.alert.core.gather.entity.AlertRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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

    @Select({"<script>",
            "<bind name='condition' value=\"'%' + search + '%'\">",
            "'%' + search + '%'",
            "</bind>",
            "select id, host, app_name as appName, term, message, es_idx as esIdx, msg_time as msgTime, insert_time as insertTime",
            "from t_alert_record",
            "<if test='search != null'>",
            "where host like #{condition}",
            "or app_name like #{condition}",
            "or term like #{condition}",
            "or message like #{condition}",
            "or es_idx like #{condition}",
            "</if>",
            "order by msg_time desc",
        "</script>"})
    List<AlertRecord> getListByPageNumSize(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize,
                                           @Param("search") String search);

}
