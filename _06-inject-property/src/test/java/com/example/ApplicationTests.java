package com.example;

import com.example.domain.Person;
import com.example.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private Person person;

    @Test
    void contextLoads() {
        System.out.println(person);
    }

    @Value(value = "${flag}")
    private String flag;

    @Value(value = "${person.id}")
    private Integer id;

    @Value(value = "${person.name}")
    private String name;

    @Value(value = "${person.family[0]}")
    private String familyOne;

    @Value(value = "${person.hobbies[0]}")
    private String hobbiesOne;

    @Test
    void test2(){
        System.out.println("flag = " + flag);
        System.out.println("id = " + id);
        System.out.println("name = " + name);
        System.out.println("familyOne = " + familyOne);
        System.out.println("hobbiesOne = " + hobbiesOne);
    }

    @Autowired
    private User user;

    @Test
    void emailValidation(){
        System.out.println("user = " + user);
    }

}
