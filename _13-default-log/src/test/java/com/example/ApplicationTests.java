package com.example;

import org.junit.jupiter.api.Test;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
    //自定义不同级别的日志
    private Logger logger = LoggerFactory.getLogger(Application.class);

    @Test
    void contextLoads() {
        logger.warn("This is a warning");
        logger.info("This is a info");
        logger.debug("This is a debug");
        logger.error("This is a error");
    }

}
