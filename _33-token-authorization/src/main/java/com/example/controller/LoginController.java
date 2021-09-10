package com.example.controller;

import com.example.domain.User;
import com.example.service.UserService;
import com.example.utils.JwtUtil;
import com.example.vo.HttpResult;
import com.example.vo.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login.do")
    public HttpResult doLogin(@RequestBody User user){
        User getuser = userService.getUserByUsername(user.getUsername());
        System.out.println("user = " + user);
        System.out.println("getuser = " + getuser);
        HttpResult httpResult = null;
        if (getuser!=null&&getuser.getPassword().equals(user.getPassword())){
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
