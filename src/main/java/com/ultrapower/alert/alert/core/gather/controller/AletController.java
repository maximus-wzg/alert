package com.ultrapower.alert.alert.core.gather.controller;

import com.github.pagehelper.PageInfo;
import com.ultrapower.alert.alert.core.gather.entity.AlertRecord;
import com.ultrapower.alert.alert.core.gather.service.AlertRecordService;
import com.ultrapower.alert.alert.core.gather.vo.SearchCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName AletController
 * @Description 告警web
 * @Author wangzhenguang
 * @Date 2020/2/17
 * @Version 1.0
 */
@RestController
public class AletController {

    @Autowired
    private AlertRecordService alertRecordService;

    @PostMapping(value = "/showAlertRecords", produces = "application/json;charset=UTF-8")
    public PageInfo<AlertRecord> show(@RequestBody SearchCondition condition) {
        if (condition == null) {
            return new PageInfo<>();
        }

        return alertRecordService.getAlertRecords(condition.getPageNum(), condition.getPageSize(), condition.getSearchText());
    }
}
