package com.example.exercise;

import com.example.exercise.domain.User;
import com.example.exercise.mapper.LogMapper;
import com.example.exercise.mapper.UserMapper;
import com.example.exercise.service.LogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class ExerciseApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private LogMapper logMapper;

    @Autowired
    private LogService logService;

    @Test
    void contextLoads() {
        logService.showLogsByUser("@baidu.com").forEach(System.out::println);

    }

    @Test
    void save(){
        User user = new User();
        user.setEmail("Uzi.com");
        user.setPassword("121212");
        userMapper.save(user);
    }


}
