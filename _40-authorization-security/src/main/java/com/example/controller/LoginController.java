package com.example.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.Column;

@Controller
public class LoginController {

    @GetMapping("/userLogin")
    public String showLoginPage(){
        return "/login/login";
    }

    /**
     *  通过 Security 提供的 SecurityContextHolder 获取登录用户信息
     * @return String
     */
    @GetMapping("/userInfo")
    @ResponseBody
    public String getUser(){
        // 获取应用上下文
        SecurityContext context = SecurityContextHolder.getContext();
        // 获取用户相关信息
        Authentication authentication = context.getAuthentication();
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        System.out.println("username: "+userDetails.getUsername());
        return "登录的用户名为： " + userDetails.getUsername();
    }

}
