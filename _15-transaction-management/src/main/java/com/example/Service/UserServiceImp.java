package com.example.Service;

import com.example.Mapper.UserMapper;
import com.example.Mapper.UserMapperImp;
import com.example.annotation.InvokeLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImp implements UserService{

    @Autowired
    private UserMapper userMapper;

    public static final Logger logger = LoggerFactory.getLogger(UserMapperImp.class);

    @Override
    @InvokeLog
    public void findAll(){
        //logger.info("----start----");
        logger.info("info-------->check");
        //System.out.println("check all date from form");
        //logger.info("----leave----");
    }

    @Override
    @InvokeLog
    public void addUser(){
        logger.info("info-------->add");
    }


}
