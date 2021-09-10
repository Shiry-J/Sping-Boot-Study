package com.example.config;

import com.example.servlet.MyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig {

    @Bean
    public ServletRegistrationBean<MyServlet> getServlet(MyServlet myServlet){

        return new ServletRegistrationBean<>(myServlet,"/myServlet");
    }

}
