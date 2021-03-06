package com.example.exercise.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String email;
    private String password;
    private Integer loginCount;
    private LocalDateTime lastLoginTime;
}
