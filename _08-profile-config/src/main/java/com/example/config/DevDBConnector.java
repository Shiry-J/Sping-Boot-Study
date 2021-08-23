package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile(value = "dev")
public class DevDBConnector implements DBConnector{

    /**
     *      在开发环境下连接数据库
     */
    @Override
    public void configuration() {
        System.out.println("开发环境下连接MySql数据库，连接成功");
    }

}
