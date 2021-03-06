package com.example.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "person", ignoreUnknownFields = true)
public class Person {

    private Integer id;
    private String name;
    private String[] family;
    private List hobbies;
    private Map map;
    //自定义宠物类
    private Pet pet;

    //setter 和 getter

}
