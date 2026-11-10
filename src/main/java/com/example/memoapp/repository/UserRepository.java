package com.example.memoapp.repository;

import com.example.memoapp.Mapper.UserMapper;
import com.example.memoapp.dto.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    private final UserMapper userMapper;

    public UserRepository(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    public User selectUserByUsername(String username) {
        return userMapper.selectUserByUsername(username);
    }
}
