package com.example.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseResult implements Serializable {

    //是否响应成功 true成功 false失败
    private boolean success;
    //响应状态码 200
    private Integer code;
    //返回 错误信息 “具体错误信息”
    private String message;
    //响应数据
    private  Object data;

}
