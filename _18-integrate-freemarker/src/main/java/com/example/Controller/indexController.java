package com.example.Controller;

import com.example.domain.User;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class indexController {

    @RequestMapping(value = "/example", method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("username","example");
        return "index";
    }

    @GetMapping("/userList")
    public String showUserList(Model model){
        model.addAttribute("username","example");
        User user1 = new User("111",20);
        User user2 = new User("222",21);
        User user3 = new User("333",22);
        User user4 = new User("444",23);
        ArrayList userList = new ArrayList();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        model.addAttribute("userList",userList);
        return "index";
    }

}
