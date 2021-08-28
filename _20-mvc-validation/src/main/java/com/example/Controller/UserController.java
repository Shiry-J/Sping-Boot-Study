package com.example.Controller;

import com.example.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @GetMapping("/register")
    public String showRegisterPage(){
        return "Register";
    }

    //@PostMapping(value = "/addUser")
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public String addUser(@Validated User user){
        return "用户注册成功,用户信息为:"+user;
    }

}
