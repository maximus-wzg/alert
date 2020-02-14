package com.ultrapower.alert.alert.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AlertCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlertCoreApplication.class, args);
    }

}
