package com.example.Controller2;

import com.example.domain.User;
import com.example.vo.ResponseResult;
import com.example.vo2.HttpResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserV2Controller {

    @GetMapping("/usersv2")
    @ResponseBody
    public HttpResult<Object> getUserList(){
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

        return HttpResult.success(userList);
    }

}
