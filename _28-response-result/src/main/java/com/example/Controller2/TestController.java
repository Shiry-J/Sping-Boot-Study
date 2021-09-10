package com.example.Controller2;

import com.example.vo2.HttpResult;
import com.example.vo2.ResultCodeEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class TestController {

    @GetMapping("/success")
    @ResponseBody
    public HttpResult success(){
        return HttpResult.success();
    }

    @GetMapping("/successwithData")
    @ResponseBody
    public HttpResult successWithData(){
        return HttpResult.success("success");
    }

    @GetMapping("/failure")
    @ResponseBody
    public HttpResult failure(){
        return HttpResult.failure(ResultCodeEnum.NOT_FOUND);
    }


}
