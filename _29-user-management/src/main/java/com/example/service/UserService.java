package com.example.service;

import com.example.domain.User;
import com.example.domain.UserParams;
import com.github.pagehelper.PageInfo;

public interface UserService {

    User getUserByUsername(String username);

    User getUserById(Integer id);

    User addUser(User user);

    User modifyUser(User user);

    void deleteUser(Integer id);

    public PageInfo<User> getUserPageList(UserParams userParams);

}
