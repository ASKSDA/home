package com.example.exercise.service;

import com.example.exercise.domain.User;

public interface SignInService {
    User signIn(String email, String password);
}
