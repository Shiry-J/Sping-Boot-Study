package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile(value = "test")
public class TestDBConnector implements DBConnector{

    /**
     *      在测试环境下连接数据库
     */
    @Override
    public void configuration() {
        System.out.println("测试环境下连接Sqlite数据库，连接成功");
    }

}
