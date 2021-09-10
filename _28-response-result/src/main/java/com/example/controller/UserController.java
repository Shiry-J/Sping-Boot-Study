package com.example.controller;

import com.example.domain.User;
import com.example.vo.ResponseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/api/v1")
public class UserController {

    //查询用户列表
    @GetMapping("/users")
    @ResponseBody
    public ResponseResult getUserList(){
        //创建一个用户列表
        User user1 = new User();
        user1.setId(1);
        user1.setName("user1");
        user1.setAge(18);
        User user2 = new User();
        user2.setId(2);
        user2.setName("user2");
        user2.setAge(20);
        ArrayList<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);

        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        responseResult.setCode(200);
        responseResult.setMessage(null);
        responseResult.setData(userList);

        return responseResult;
    }

    //根据id查询用户信息
    @GetMapping("/users/{id}")
    @ResponseBody
    public ResponseResult getUser(@PathVariable("id") Integer id){
        //创建一个用户列表
        User user1 = new User();
        user1.setId(1);
        user1.setName("user1");
        user1.setAge(18);

        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        responseResult.setCode(200);
        responseResult.setMessage(null);
        responseResult.setData(user1);

        return responseResult;
    }

    //添加用户
    @PostMapping("/addusers")
    @ResponseBody
    public ResponseResult addUser(@RequestBody User user){

        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        responseResult.setCode(200);
        responseResult.setMessage(null);
        responseResult.setData(user);

        return responseResult;
    }

    //修改用户信息
    //根据id查询用户信息
    /*@PostMapping("/uploadusers/{id}/{name}/{age}")
    @ResponseBody
    public ResponseResult uploadUser(@PathVariable("id") Integer id,
                                     @PathVariable("name") String name,
                                     @PathVariable("age") Integer age
                                  ){
        //创建一个用户列表
        User user1 = new User();
        user1.setId(1);
        user1.setName("user1");
        user1.setAge(18);
        User user2 = new User();
        user2.setId(2);
        user2.setName("user2");
        user2.setAge(20);
        ArrayList<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);

        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        responseResult.setCode(200);
        responseResult.setMessage(null);

        for (User user:userList){
            if(user.getId() == id){
                user.setName(name);
                user.setAge(age);

                responseResult.setData(user1);
            }
        }

        return responseResult;
    }*/

    @PutMapping("/uploadusers")
    @ResponseBody
    public ResponseResult uploadUser(@RequestBody User user) {

        User user1 = new User();
        user1.setId(1);
        user1.setName("user1");
        user1.setAge(18);

        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        responseResult.setCode(200);
        responseResult.setMessage(null);
        responseResult.setData(user);

        return responseResult;
    }


    //删除用户
    @DeleteMapping("/delusers/{id}")
    @ResponseBody
    public ResponseResult delUser( @PathVariable("id")Integer id){

        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        responseResult.setCode(200);
        responseResult.setMessage(null);
        responseResult.setData("id:"+id+"删除成功");

        return responseResult;
    }
}
