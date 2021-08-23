package com.example;

import com.example.config.DBConnector;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private DBConnector dbConnector;

    @Test
    void contextLoads() {
        dbConnector.configuration();
    }

}
