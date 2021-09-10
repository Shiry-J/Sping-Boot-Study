package com.example.vo;

import lombok.Data;

//响应信息封装类
@Data
public class ResultInfo {

    private Integer code;  //响应状态码

    private String msg;  //说明响应状态码含义

    private Object data;  //程序后端返回给前端（浏览器）的数据信息

}
