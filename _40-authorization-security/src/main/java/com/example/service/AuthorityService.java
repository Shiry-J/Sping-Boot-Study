package com.example.service;

import com.example.domain.Authority;

import java.util.List;

public interface AuthorityService {

    public List<Authority> findAuthoritiesByUsername(String username);
}
