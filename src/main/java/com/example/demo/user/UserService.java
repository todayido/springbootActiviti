package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User getUsername(String id) {
        return userMapper.selectByPrimaryKey(Integer.parseInt(id));
    }

}
