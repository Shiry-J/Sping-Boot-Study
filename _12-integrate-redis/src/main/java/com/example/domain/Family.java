package com.example.domain;

import lombok.Data;
import org.springframework.data.redis.core.index.Indexed;

@Data
public class Family {

    @Indexed
    private String type;
    @Indexed
    private String name;

}
