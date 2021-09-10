package com.example.service;

import com.example.bo.UserParams;
import com.example.domain.User;
import com.example.mapper.UserMapper;
import com.example.utils.AssertUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Cacheable(value = "users",key = "#username")
    public User getUserByUsername(String username) {
        return this.userMapper.getUserByUsername(username);
    }

    @Override
    @Cacheable(value = "users",key = "#id")
    public User getUserById(Integer id) {
        return this.userMapper.getUserById(id);
    }

    @Override
    public User addUser(User user){
        //AssertUtil.isTrue(StringUtils.isBlank(user.getUsername()),301,"用户名为空，请重新输入");
        //AssertUtil.isTrue(StringUtils.isBlank(user.getPassword()),302,"密码为空，请重新输入");

        AssertUtil.isTrue(userMapper.getUserByUsername(user.getUsername()) !=null,520,"用户名重复，请重新输入");

        int i = userMapper.addUser(user);
        User user1 = null;
        if (i==1){
            user1 = this.getUserByUsername(user.getUsername());
        }else{
            System.out.println("添加用户失败");
        }
        //AssertUtil.isTrue(i < 1, 303,"添加用户失败");
        //AssertUtil.isTrue(i == 1, 200, "添加用户成功");
        return user1;
    }

    @Override
    @CachePut(value = "users",key = "#user.id")
    public User modifyUser(User user) {
        User userByUsername = this.userMapper.getUserByUsername(user.getUsername());
        AssertUtil.isTrue(userByUsername != null && user.getId().equals(userByUsername.getId()),520,"用户名重复，请重新输入");
        //修改用户信息
        int i = userMapper.modifyUser(user);

        return this.getUserByUsername(user.getUsername());

    }

    @Override
    @CacheEvict(value = "users",allEntries = true)
    public void deleteUser(Integer id) {

        //是否存在该用户
        User userById = this.getUserById(id);

        //删除用户
        if (userById != null){
            this.userMapper.deleteUser(id);
        }else {
            System.out.println("删除用户失败");
        }

    }

    @Override
    @Cacheable(value = "users",key = "#userParams.pageNum+'-'+#userParams.pageSize+'-'+#userParams.username")
    public PageInfo<User> getUserPageList(UserParams userParams) {

        PageHelper.startPage(userParams.getPageNum(), userParams.getPageSize());

        return new PageInfo<User>(this.userMapper.getUserList(userParams));
    }

}
