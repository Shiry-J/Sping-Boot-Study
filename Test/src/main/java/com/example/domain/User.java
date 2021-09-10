package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;
    @NotBlank(message = "用户名不能为空")
    private String username;
    @Length(min = 3,max = 15,message = "密码长度为3-15之间")
    @NotBlank(message = "密码不能为空")
    private String password;
    @Email
    @NotBlank(message = "邮箱不能为空")
    private String email;
    @NotBlank(message = "地址不能为空")
    private String address;
    private Date birthday;
    private String createBy;
    private Date createTime;
    private String modifyBy;
    private Date modifyTime;

}
