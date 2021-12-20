package com.example.exercise.service.impl;


import com.example.exercise.domain.Log;
import com.example.exercise.mapper.LogMapper;
import com.example.exercise.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;

    @Override
    public List<Log> showLogsByUser(String email) {
        return logMapper.findByEmail(email);
    }

    @Transactional
    @Override
    public boolean save(Log log) {
        return logMapper.save(log) > 0;
    }
}