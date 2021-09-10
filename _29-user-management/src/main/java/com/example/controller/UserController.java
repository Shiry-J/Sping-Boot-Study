package com.example.controller;

import com.example.domain.User;
import com.example.domain.UserParams;
import com.example.service.UserService;
import com.example.utils.ParamsException;
import com.example.vo.HttpResult;
import com.example.vo.ResultCodeEnum;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{username}")
    public HttpResult getUserByUsername(@PathVariable String username){
        User userByUsername = this.userService.getUserByUsername(username);
        return HttpResult.success(userByUsername);
    }

    @GetMapping("/users/{id}")
    public HttpResult<Object> getUserById(@PathVariable("id") Integer id){
        User user = this.userService.getUserById(id);
        return HttpResult.success(user);
    }

    @PostMapping("/adduser")
    public HttpResult addUser(@RequestBody User user){

        User user1 = this.userService.addUser(user);
        return HttpResult.success(user1);

    }

    @PutMapping("/updateuser")
    public HttpResult modifyUser(@RequestBody User user){

        User user1 = this.userService.modifyUser(user);
        return HttpResult.success(user1);

    }

    @DeleteMapping("/deleteuser/{id}")
    public HttpResult deleteUser(@PathVariable Integer id) {

        this.userService.deleteUser(id);
        return HttpResult.success();

    }

    @GetMapping("/user/list")
    public HttpResult getUserPageList(@RequestBody UserParams userParams){
        PageInfo<User> userPageList = this.userService.getUserPageList(userParams);
        return HttpResult.success(userPageList);
    }

}