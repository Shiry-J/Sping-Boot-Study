package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile(value = "prod")
public class ProDBConnector implements DBConnector{

    /**
     *      在生产环境下连接数据库
     */
    @Override
    public void configuration() {
        System.out.println("生产环境下连接Oracle数据库，连接成功");
    }

}
