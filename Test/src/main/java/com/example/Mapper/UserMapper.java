package com.example.Mapper;

import com.example.domain.User;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    //查询所有表内容
    List<User> getUserList();

    //增加一条信息
    int addUser(User user);

    //删除一条信息
    int delUser(@Param("id") int id);

    //修改一条信息
    int updateUser(User user);

    //查看一条信息
    User getUserById(@Param("id") int id);

}
