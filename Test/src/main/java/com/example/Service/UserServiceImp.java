package com.example.Service;

import com.example.Mapper.UserMapper;
import com.example.Mapper.UserMapperImp;
import com.example.annotation.InvokeLog;
import com.example.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImp implements UserService{

    @Autowired
    private UserMapper userMapper;

    public static final Logger logger = LoggerFactory.getLogger(UserMapperImp.class);

    @Override
    @InvokeLog
    public List<User> getUserList(){
        logger.info("info-------->getUserList");
        return userMapper.getUserList();
    }

    @Override
    @InvokeLog
    public int addUser(User user){
        logger.info("info-------->addUser");
        return userMapper.addUser(user);
    }

    @Override
    @InvokeLog
    public int updateUser(User user){
        logger.info("info-------->updateUser");
        return userMapper.updateUser(user);
    }

    @Override
    @InvokeLog
    public User getUserById(Integer id){
        logger.info("info-------->getUserById");
        return userMapper.getUserById(id);
    }

    @Override
    @InvokeLog
    public int delUser(Integer id){
        logger.info("info-------->delUser");
        return userMapper.delUser(id);
    }

}
