package com.meethong.service;

import com.meethong.mapper.UserMapper;
import com.meethong.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserserviceImpl implements Userservice{

    @Autowired
    UserMapper userMapper;
    @Override
    public User querUserByName(String username) {
        return userMapper.querUserByName(username);
    }
}
