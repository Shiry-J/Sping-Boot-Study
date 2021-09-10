package com.example.controller;


import com.example.domain.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    @ResponseBody
    public List<User> getUserList(){
        System.out.println(userService.getUserList());
        return userService.getUserList();
    }

    @RequestMapping("/users/{id}")
    public String getUserById(@PathVariable("id") Integer id){
        if (id==2){
            User zhubajie = new User(3, "zhubajie", "zhubajie");
            return "Get Successfully";
        }else{
            System.out.println("该用户不存在");
            return "Get failure";
        }
    }


}
