package com.example.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;

@Component
@Data
@ConfigurationProperties(prefix = "user", ignoreUnknownFields = true)
@Validated
public class User {

    @Email
    private String email;

}
