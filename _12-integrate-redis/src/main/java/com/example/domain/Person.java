package com.example.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.util.List;

@Data
@RedisHash(value = "people")
public class Person {

    @Id
    private String id;
    @Indexed
    private String firstName;
    @Indexed
    private String lastName;
    private Address address;
    private List<Family> FamilyList;

}
