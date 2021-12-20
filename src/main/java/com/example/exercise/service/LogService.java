package com.example.exercise.service;

import com.example.exercise.domain.Log;

import java.util.List;

public interface LogService {
    List<Log> showLogsByUser(String email);
    boolean save(Log log);
}
