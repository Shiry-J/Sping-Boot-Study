package com.example.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "User实体类")
public class User {

    @ApiModelProperty(name = "id",value = "用户id",example = "1")
    private Integer id;
    @ApiModelProperty(name = "username",value = "用户名")
    @NotBlank(message = "username not null")
    private String username;
    @ApiModelProperty(name = "password",value = "用户密码")
    @NotBlank(message = "password not null")
    private String password;

}
