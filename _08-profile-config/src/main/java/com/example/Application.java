package com.example;

import com.example.config.DBConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    //@Autowired
    //private static DBConnector dbConnector;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        //dbConnector.configuration();
    }

}
