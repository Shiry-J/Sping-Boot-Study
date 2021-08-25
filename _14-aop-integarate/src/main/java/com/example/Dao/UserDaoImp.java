package com.example.Dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImp implements UserDao{

    public static final Logger logger = LoggerFactory.getLogger(UserDaoImp.class);

    @Override
    public void findAll(){
        logger.info("info-------->check");
        System.out.println("check all date from form");
    }

}
