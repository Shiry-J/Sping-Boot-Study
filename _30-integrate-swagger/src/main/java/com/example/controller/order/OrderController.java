package com.example.controller.order;

import com.example.domain.User;
import com.example.vo.HttpResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class OrderController {

    @GetMapping("/orders/id/{id}")
    @ApiOperation(value = "getOrderById接口", notes = "根据id查询用户")
    @ApiImplicitParam(name = "id", value = "用户id字段",
            required = true,dataType = "int",
            paramType = "path",defaultValue = "1"
    )
    public HttpResult getOrderById(@PathVariable("id") Integer id){
        return null;
    }


}
