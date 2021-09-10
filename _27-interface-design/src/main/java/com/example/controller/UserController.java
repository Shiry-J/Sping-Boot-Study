package com.example.controller;

import com.example.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

        @RequestMapping(value = "/testParams",method = RequestMethod.GET,params = "!code=1234")
        @ResponseBody
        public String testParams(){
            System.out.println("testParams处理了请求");
            return "testParams";
        }


        @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
        public String findUserById( @PathVariable("id")Integer id){
            System.out.println(id);
            return "findUserById";
        }

        @RequestMapping(value = "/user/{id}/{name}",method = RequestMethod.GET)
        public String findUser(@PathVariable("id") Integer id,@PathVariable("name") String name){
            System.out.println(id);
            System.out.println(name);
            return "findUser";
        }

        @RequestMapping(value = "/users",method = RequestMethod.POST)
        public String insertUser(@RequestBody List<User> user){
            System.out.println(user);
            return "insertUser";
        }

        //分页查询
        @GetMapping(value = "/userss/{baga}/{yalu}")
        public String querryUserList(@RequestParam("page") Integer curPageNo,
                                     @RequestParam("per_page") Integer pageSize,
                                     @PathVariable("baga") Integer id,
                                     @PathVariable("yalu") String username){
            System.out.println(curPageNo);
            System.out.println(pageSize);
            return "分页查询";
        }

}
