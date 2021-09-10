package com.example.service;

import com.example.bo.UserParams;
import com.example.domain.User;
import com.github.pagehelper.PageInfo;

public interface UserService {

    User getUserByUsername(String username);

    User getUserById(Integer id);

    User addUser(User user);

    User modifyUser(User user);

    void deleteUser(Integer id);

    PageInfo<User> getUserPageList(UserParams userParams);

}
