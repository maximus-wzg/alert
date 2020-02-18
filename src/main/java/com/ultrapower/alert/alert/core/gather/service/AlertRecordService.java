package com.ultrapower.alert.alert.core.gather.service;

import com.github.pagehelper.PageInfo;
import com.ultrapower.alert.alert.core.gather.entity.AlertRecord;

import java.util.List;

/**
 * @ClassName AlertRecordService
 * @Description
 * @Author wangzhenguang
 * @Date 2020/2/17
 * @Version 1.0
 */
public interface AlertRecordService {

    /**
     * 分页查询告警记录
     * @param page
     * @param pageSize
     * @return
     */
    PageInfo<AlertRecord> getAlertRecords(int page, int pageSize, String search);

}
