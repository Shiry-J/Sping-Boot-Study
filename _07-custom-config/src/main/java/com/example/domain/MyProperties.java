package com.example.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Data
@PropertySource(value = {"classpath:test.properties"})
@ConfigurationProperties(prefix = "test")
public class MyProperties {

    private Integer id;

    private  String name;

}
