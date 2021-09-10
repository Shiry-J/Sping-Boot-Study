package com.example.Mapper;

import com.example.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.crypto.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void getUserList() {
        System.out.println("搜索结果为:"+userMapper.getUserList());
    }

    @Test
    void addUser() throws ParseException {
        User user = new User();
        user.setUsername("username");
        user.setPassword("user123");
        user.setEmail("user123@163.com");
        user.setAddress("东方大道123号");
        Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse("2000-11-11");
        user.setBirthday(birthday);
        user.setCreateBy("admin");
        Date date = new Date();
        user.setCreateTime(date);
        user.setModifyBy("admin");
        user.setModifyTime(date);
        System.out.println("添加结果为:"+userMapper.addUser(user));
    }

    @Test
    void delUser() {
        System.out.println("删除结果为:"+userMapper.delUser(2));
    }

    @Test
    void updateUser() throws ParseException {
        User user = new User();
        user.setId(3);
        user.setUsername("admin");
        user.setPassword("admin123");
        user.setEmail("admin123@163.com");
        user.setAddress("东方大道123号");
        Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse("1999-11-11");
        user.setBirthday(birthday);
        Date date = new Date();
        user.setModifyBy("admin");
        user.setModifyTime(date);
        System.out.println("修改结果为:"+userMapper.updateUser(user));
    }

    @Test
    void getUserById() {
        System.out.println("搜索结果为:"+userMapper.getUserById(1));
    }
}