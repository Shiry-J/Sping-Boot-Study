package com.example.service;

import com.example.domain.User;

import java.util.List;

public interface UserService {

    User getUserByUsername(String username);

    User getUserById(Integer id);

    List<User> getUserList();


}
