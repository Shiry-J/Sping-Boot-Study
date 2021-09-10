package com.example.config;

import com.example.servlet.MyListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListenerConfig {

    @Bean
    public ServletListenerRegistrationBean<MyListener> getListener(MyListener myListener){
        return new ServletListenerRegistrationBean<>(myListener);
    }

}