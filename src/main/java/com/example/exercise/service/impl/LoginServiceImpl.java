package com.example.exercise.service.impl;

import com.example.exercise.domain.Log;
import com.example.exercise.domain.User;
import com.example.exercise.mapper.LogMapper;
import com.example.exercise.mapper.UserMapper;
import com.example.exercise.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private LogMapper logMapper;

    @Transactional
    @Override
    public User login(String email, String password) {
        User user = userMapper.findByEmailAndPassword(email, password);
        if(user != null){
            Log log = new Log();
            log.setLoginTime(LocalDateTime.now());
            log.setUser(user);
            logMapper.save(log);
            userMapper.update(email,LocalDateTime.now());
            return user;
        } else {
            return null;
        }
    }
}
