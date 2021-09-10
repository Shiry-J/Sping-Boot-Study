package com.example.utils;

public class ParamsException extends RuntimeException {

    private Integer type = 300;
    private String msg = "默认自定义异常类型";

    public ParamsException(){
        super();
    }

    public ParamsException(Integer type){
        this.type = type;
    }

    public ParamsException(String msg) {
        this.msg = msg;
    }

    public  ParamsException(Integer type, String msg) {
        this.type = type;
        this.msg = msg;
    }

    public Integer getType() {
        return type;
    }

    public void settype(Integer type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
