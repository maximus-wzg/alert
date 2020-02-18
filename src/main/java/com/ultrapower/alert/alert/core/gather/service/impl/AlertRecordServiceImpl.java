package com.ultrapower.alert.alert.core.gather.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ultrapower.alert.alert.core.gather.entity.AlertRecord;
import com.ultrapower.alert.alert.core.gather.mapper.AlertRecordMapper;
import com.ultrapower.alert.alert.core.gather.service.AlertRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName AlertRecordServiceImpl
 * @Description
 * @Author wangzhenguang
 * @Date 2020/2/17
 * @Version 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AlertRecordServiceImpl implements AlertRecordService {

    @Autowired
    private AlertRecordMapper mapper;

    @Override
    public PageInfo<AlertRecord> getAlertRecords(int pageNum, int pageSize, String search) {
        List<AlertRecord> records = mapper.getListByPageNumSize(pageNum, pageSize, search);
        return new PageInfo<>(records);
    }
}
