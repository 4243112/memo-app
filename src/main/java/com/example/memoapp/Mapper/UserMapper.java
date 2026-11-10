package com.example.memoapp.Mapper;

import com.example.memoapp.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("SELECT user_id, user_name, password, created_at FROM users WHERE username = #{username}")
    User selectUserByUsername(String username);
}