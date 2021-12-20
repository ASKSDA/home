package com.example.exercise.service.impl;

import com.example.exercise.domain.User;
import com.example.exercise.mapper.UserMapper;
import com.example.exercise.service.SignInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignInServiceImpl implements SignInService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User signIn(String email, String password) {
        if(userMapper.findEmail(email) != null){
            return null;
        } else {
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            userMapper.save(user);
            return user;
        }
    }
}
