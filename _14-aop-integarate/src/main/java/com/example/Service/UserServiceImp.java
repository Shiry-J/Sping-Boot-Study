package com.example.Service;

import com.example.Dao.UserDaoImp;
import com.example.annotation.InvokeLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{

    public static final Logger logger = LoggerFactory.getLogger(UserDaoImp.class);

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
