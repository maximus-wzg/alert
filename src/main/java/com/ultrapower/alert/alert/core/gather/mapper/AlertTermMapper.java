package com.ultrapower.alert.alert.core.gather.mapper;

import com.ultrapower.alert.alert.core.gather.entity.AlertTerm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName AlertTermMapper
 * @Description 告警关键字
 * @Author wangzhenguang
 * @Date 2020/2/14
 * @Version 1.0
 */
@Mapper
public interface AlertTermMapper {

    @Select(" select * from t_alert_term ")
    List<AlertTerm> getAll();

}
