package com.example.mapper;

import com.example.domain.User;
import com.example.domain.UserParams;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    User getUserByUsername(String username);

    User getUserById(Integer id);

    int addUser(User user);

    int modifyUser(User user);

    int deleteUser(Integer id);

    List<User> getUserList(UserParams userParams);


}
