package com.ultrapower.alert.alert.core.gather.service;

import com.ultrapower.alert.alert.core.gather.entity.AlertRecord;
import com.ultrapower.alert.alert.core.gather.entity.AlertTerm;
import com.ultrapower.alert.alert.core.gather.mapper.AlertRecordMapper;
import com.ultrapower.alert.alert.core.gather.mapper.AlertTermMapper;
import com.ultrapower.alert.alert.core.gather.util.DateTimeUtil;
import com.ultrapower.alert.alert.core.gather.util.UUIDGenerator;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName DataGather
 * @Description 数据采集服务
 * @Author wangzhenguang
 * @Date 2020/2/13
 * @Version 1.0
 */
@Service
public class DataGather {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${alert.period}")
    private long period;

    @Autowired
    private RestHighLevelClient client;

    @Autowired
    private AlertTermMapper termMapper;

    @Autowired
    private AlertRecordMapper recordMapper;

    /**
     * 每5分钟采集一次数据
     */
    @Scheduled(fixedRateString = "${alert.period}")
    public void gather() {
        List<AlertTerm> termList = termMapper.getAll();
        List<String> terms = new ArrayList<>();
        for (AlertTerm term : termList) {
            terms.add(term.getTerm());
        }
        if (terms.size() == 0) {
            logger.error("没有维护告警关键字，无法进行数据采集");
            return;
        }
        try {
            List<AlertRecord> alertRecords = getAlertRecords(terms);
            for (AlertRecord record : alertRecords) {
                recordMapper.save(record);
            }
        } catch (IOException e) {
            logger.error("从ES获取告警记录失败：" + e.getMessage(), e);
        }
    }

    /**
     * 根据告警关键字列表获取告警记录
     * @param terms 告警关键字列表
     * @return 告警记录列表
     */
    private List<AlertRecord> getAlertRecords(List<String> terms) throws IOException {
        long now = System.currentTimeMillis();
        long begin = now - period;
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery()
                .must(QueryBuilders.termsQuery("message", terms))
                .must(QueryBuilders.rangeQuery("@timestamp").gt(begin).lte(now));

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(boolQueryBuilder);

        SearchRequest searchRequest = new SearchRequest();
        searchRequest.source(searchSourceBuilder);

        SearchResponse response = client.search(searchRequest, new BasicHeader("Content-Type", "application/json"));
        SearchHits hits = response.getHits();

        List<AlertRecord> records = new ArrayList<>();
        Date insertTime = new Date();
        for (SearchHit hit : hits) {
            AlertRecord alertRecord = new AlertRecord();
            alertRecord.setId(UUIDGenerator.getId());
            alertRecord.setEsIdx(hit.getIndex());

            Map<String, Object> sourceMap = hit.getSourceAsMap();

            alertRecord.setHost(sourceMap.get("chost").toString());
            alertRecord.setAppName(sourceMap.get("cappname").toString());
            String message = sourceMap.get("message").toString();

            // 查找并设置告警关键字
            for (String term : terms) {
                if (message.contains(term)) {
                    alertRecord.setTerm(term);
                    break;
                }
            }

            alertRecord.setMessage(message);
            alertRecord.setInsertTime(insertTime);
            try {
                alertRecord.setMsgTime(DateTimeUtil.parseUTC(sourceMap.get("@timestamp").toString()));
            } catch (ParseException e) {
                logger.error("设置告警记录的消息时间失败, record id: {}", alertRecord.getId(), e);
            }
            records.add(alertRecord);
        }
        return records;
    }



}
