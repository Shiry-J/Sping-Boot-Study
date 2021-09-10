package com.example.mapper;

import com.example.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    User getUserByUsername(String username);

    User getUserById(Integer id);

    List<User> getUserList();

}
