package com.example;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        // SpringApplication.run(Application.class, args);
        SpringApplication springApplication = new SpringApplication(Application.class);
        // 关闭 banner 图标
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run();
    }

}
