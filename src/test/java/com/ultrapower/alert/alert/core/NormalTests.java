package com.ultrapower.alert.alert.core;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * @ClassName NormalTests
 * @Description
 * @Author wangzhenguang
 * @Date 2020/2/14
 * @Version 1.0
 */
@SpringBootTest
public class NormalTests {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void test1() {
        List<String> terms = new ArrayList<>();
        terms.add("hello");
        terms.add("OutOfMemory");

        String message = "111 hello 222 OutOfMemory";

        for (String term : terms) {
            logger.info(term);
            if (message.contains(term)) {
                logger.info("found:{}", term);
                break;
            }
        }
    }

    @Test
    public void test2() {
        String time = "2020-02-14T06:06:33.047Z";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            Date date = dateFormat.parse(time);
            logger.info("parsed : {}", date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
