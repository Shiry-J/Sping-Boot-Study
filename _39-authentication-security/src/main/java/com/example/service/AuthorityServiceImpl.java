package com.example.service;

import com.example.repository.AuthorityRepository;
import com.example.domain.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorityServiceImpl implements AuthorityService{
    @Autowired
    private AuthorityRepository authorityRepository;
    @Autowired
    private RedisTemplate redisTemplate;

    // 整合 redis 缓存，根据唯一用户名查询权限列表
    public List<Authority> findAuthoritiesByUsername(String username){
        List<Authority> authorities=null;
        Object o = redisTemplate.opsForValue().get("authorities_" + username);
        if(o!=null){
            authorities=(List<Authority>) o;
        }else {
            authorities=authorityRepository.findAuthoritiesByUsername(username);
            if(authorities.size()>0){
                redisTemplate.opsForValue().set("authorities_"+username,authorities);
            }
        }
        return authorities;
    }

}
