package com.example;

import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    @Test
    public void contextLoads(){
        System.out.println("Studying!");
        System.out.println("My Web:test.com");
    }

    @Test
    public void userAddTest(){
        System.out.println("User Add Successfully!");
    }

    @Test
    public void userDeleteTest(){
        System.out.println("User Delete Successfully!");
    }

    @Test
    public void userModifyTest(){
        System.out.println("User Modify Successfully!");
    }

    public void userQuerryTest(){
        System.out.println("User search Successfully");
    }

}
