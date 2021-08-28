package com.example;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Data
public class User {

    private Integer id;
    @NotBlank(message = "用户名不能为空")
    private String username;
    @Length(min = 3,max = 10,message = "密码长度为3-10之间")
    @NotBlank(message = "密码不能为空")
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
