package com.example.exception;

import com.example.vo.ResultInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    //处理所有异常
    @ExceptionHandler
    @ResponseBody
    public ResultInfo handleException(Exception e){
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(520);
        resultInfo.setMsg("系统异常");
        resultInfo.setData(e.getMessage());
        return resultInfo;
    }

}
