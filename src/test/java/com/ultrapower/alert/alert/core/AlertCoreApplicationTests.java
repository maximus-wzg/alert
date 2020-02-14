package com.ultrapower.alert.alert.core;

import com.ultrapower.alert.alert.core.gather.service.DataGather;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlertCoreApplicationTests {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DataGather dataGather;


    @Test
    public void test1() {
        logger.error("i am an error msg");
    }

    @Test
    public void test2() {
        dataGather.gather();
    }


}
