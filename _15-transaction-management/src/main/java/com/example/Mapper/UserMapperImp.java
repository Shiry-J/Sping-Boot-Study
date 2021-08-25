package com.example.Mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UserMapperImp implements UserMapper{

    public static final Logger logger = LoggerFactory.getLogger(UserMapperImp.class);

    @Override
    public void findAll(){
        logger.info("info-------->check");
        System.out.println("check all date from form");
    }

}
