package com.example.Controller;

import com.example.domain.User;
import com.example.vo.ResultInfo;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("/register")
    public String showRegisterPage(){
        return "Register";
    }


    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo addUser(@Validated User user){
        ResultInfo resultInfo = new ResultInfo();
        System.out.println("用户添加成功");
        resultInfo.setCode(521);
        resultInfo.setMsg("用户添加成功");
        resultInfo.setData(user);
        return resultInfo;
    }

    @PostMapping(value = "/test")
    @ResponseBody
    public ResultInfo test(){
        int i = 10/0;
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setCode(522);
        resultInfo.setMsg("test Successfully");
        return resultInfo;
    }

    //@PostMapping(value = "/addUser")
    /*@RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo addUser(@Validated User user, BindingResult bindingResult){
        ResultInfo resultInfo = new ResultInfo();
        List<Object> list = new ArrayList<>();
        if (bindingResult.hasErrors()){
            bindingResult.getAllErrors().forEach(e ->{
                list.add(e.getDefaultMessage());
            });
        }else {
            list.add("后台数据校验成功");
        }
        resultInfo.setCode(1314);
        resultInfo.setData(list);
        resultInfo.setMsg("注册异常");
        return resultInfo;
    }*/

}
