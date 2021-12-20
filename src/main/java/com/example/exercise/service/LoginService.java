package com.example.exercise.service;

import com.example.exercise.domain.User;

public interface LoginService {
    User login(String email, String password);
}
