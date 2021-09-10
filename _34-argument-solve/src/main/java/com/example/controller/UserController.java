package com.example.controller;


import com.example.annotation.CurrentUserId;
import com.example.domain.User;
import com.example.service.UserService;
import com.example.vo.HttpResult;
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


    @GetMapping("/users/id")
    public HttpResult getUserById(@CurrentUserId Integer userId){
        System.out.println("userId = " + userId);
        User userById = this.userService.getUserById(userId);
        return HttpResult.success(userById);
    }


}
