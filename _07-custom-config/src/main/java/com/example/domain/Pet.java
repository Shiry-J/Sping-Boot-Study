package com.example.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = {"classpath:test.properties"})
@ConfigurationProperties(prefix = "pet")
public class Pet {

    private String petName;
    private Integer petAge;

    public String getPetName() {
        return petName;
    }

    public Integer getPetAge() {
        return petAge;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public void setPetAge(Integer petAge) {
        this.petAge = petAge;
    }

    @Override
    public String toString() {
        return "MyPet{" +
                "petName=" + petName +
                ", petAge='" + petAge + '\'' +
                '}';
    }

}
