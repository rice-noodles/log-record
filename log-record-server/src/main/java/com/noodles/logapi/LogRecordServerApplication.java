package com.noodles.logapi;

import com.noodles.logapi.annotation.EnableLogRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: noodles
 * @Date: 2022/01/10 22:18
 */
@SpringBootApplication
@EnableLogRecord
public class LogRecordServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(LogRecordServerApplication.class, args);
    }
}
