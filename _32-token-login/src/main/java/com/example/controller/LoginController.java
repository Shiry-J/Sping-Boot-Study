package com.example.controller;

import com.example.domain.User;

import com.example.utils.JwtUtil;
import com.example.vo.HttpResult;
import com.example.vo.ResultCodeEnum;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class LoginController {

    @PostMapping("/login.do")
    public HttpResult doLogin(User user){
        HttpResult httpResult = null;
        if (user.getUsername().equals("Shiry")&&user.getPassword().equals("Shiry")){
            //生成token返回客户端
            String token = JwtUtil.createJWT(UUID.randomUUID().toString(),"1",60000L);
            System.out.println("token="+token);
            HashMap<String,String> map = new HashMap<>();
            map.put("token",token);
            httpResult = HttpResult.success(map);
        }else{
            httpResult = HttpResult.failure(ResultCodeEnum.ERROR_USERNAME_OR_PASSWORD);
        }
        return httpResult;
    }

}
