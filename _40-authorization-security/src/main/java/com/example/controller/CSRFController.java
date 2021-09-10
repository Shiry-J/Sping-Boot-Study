package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CSRFController {

    @GetMapping("/updateUser")
    public String showCSRFPage(){
        return "/csrf/csrfTest";
    }

    @ResponseBody
    @PostMapping("/updateUser")
    public String updateUser(@RequestParam("username") String username,
                             HttpServletRequest request
    ){
        System.out.println("request = " + request);

        String csrf_token=request.getParameter("_csrf");
        System.out.println("csrf_token = " + csrf_token);

        System.out.println("username = " + username);
        return "success";
    }

}
