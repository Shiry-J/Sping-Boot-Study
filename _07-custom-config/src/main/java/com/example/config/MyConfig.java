package com.example.config;

import com.example.domain.Pet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean(name = "aPet")
    public Pet getPet(){
        return new Pet();
    }

}
