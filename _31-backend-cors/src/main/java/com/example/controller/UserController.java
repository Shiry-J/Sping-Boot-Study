package com.example.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin
@RestController
public class UserController {

    @PostMapping("/api/v1/users")
    public String getUserList(HttpServletResponse response){
        //response.setHeader("Access-Controller-Allow-Origin","*");
        return "get UserList";
    }

}
