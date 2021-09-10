package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class NewsController {

    @GetMapping("/detail/{type}/{id}")
    public String newsShow(@PathVariable("type") String type,@PathVariable("id") String id){
        return "detail/"+type+"/"+id;
    }

}
