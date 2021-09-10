package com.example.service;

import com.example.domain.Customer;

public interface CustomerService {

    // 根据用户名查询用户信息
    Customer findByUsername(String username);
}
