package com.example.exception;

import com.example.utils.ParamsException;
import com.example.vo.HttpResult;
import com.example.vo.ResultCodeEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler
    public HttpResult handlerGolabelException(Exception e){
        HttpResult httpResult = null;
        if (e instanceof ParamsException){
            ParamsException paramsException = (ParamsException) e;
            if (paramsException.getType() == 520){
                httpResult = HttpResult.failure(ResultCodeEnum.USERNAME_REPEAT);
            }
        }else{
            httpResult = HttpResult.failure(ResultCodeEnum.UNKNOWN_ERROR);
            e.printStackTrace();
        }
        return httpResult;
    }
}
