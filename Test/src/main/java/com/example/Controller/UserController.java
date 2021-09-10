package com.example.Controller;

import com.example.Service.UserService;
import com.example.domain.User;
import com.example.vo.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/register")
    public String showRegisterPage(){
        return "Register";
    }

    //@PostMapping(value = "/addUser")
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

    @RequestMapping("/work")
    public String showWorkPage(){
        return "Work";
    }

    @RequestMapping("/doadd")
    @ResponseBody
    public String showAddResult(HttpServletRequest request) throws ParseException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = ft.parse(request.getParameter("birthday"));
        Date date = new Date();
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setAddress(address);
        user.setBirthday(birthday);
        user.setEmail(email);
        user.setModifyTime(date);
        user.setModifyBy("admin");
        user.setCreateTime(date);
        user.setCreateBy("admin");
        int i = userService.addUser(user);
        if(i == 1){
            return "增加成功";
        }
        return "增加失败";
    }

    @RequestMapping("/dodelete")
    @ResponseBody
    public String showDeleteResult(HttpServletRequest request){
        Integer id = Integer.valueOf(request.getParameter("del_id"));
        int i = userService.delUser(id);
        if(i == 1){
            return "删除成功";
        }
        return "删除失败";
    }

    @RequestMapping("/domodify")
    @ResponseBody
    public String showModifyResult(HttpServletRequest request) throws ParseException {
        Integer id = Integer.valueOf(request.getParameter("up_id"));
        String username = request.getParameter("up_username");
        String password = request.getParameter("up_password");
        String email = request.getParameter("up_email");
        String address = request.getParameter("up_address");
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = ft.parse(request.getParameter("up_birthday"));
        Date date = new Date();
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setAddress(address);
        user.setBirthday(birthday);
        user.setEmail(email);
        user.setModifyTime(date);
        user.setModifyBy("admin");
        int i = userService.updateUser(user);
        if(i == 1){
            return "修改成功";
        }
        return "修改失败";
    }

    @RequestMapping("/dosearch")
    @ResponseBody
    public String showSearchResult(HttpServletRequest request){
        Integer id = Integer.valueOf(request.getParameter("id"));
        User user = userService.getUserById(id);
        return "结果为:"+user;
    }

    @RequestMapping("/dosearchall")
    @ResponseBody
    public String showSearchAllResult(){
        List<User> userList = userService.getUserList();
        return "结果为:"+userList;
    }

}
