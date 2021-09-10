package com.example.Service;

import com.example.domain.User;

import java.util.List;

public interface UserService {

    public List<User> getUserList();

    public int addUser(User user);

    public int updateUser(User user);

    public User getUserById(Integer id);

    public int delUser(Integer id);

}
