package com.example.exercise.mapper;

import com.example.exercise.domain.Log;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LogMapper {
    int save(Log log);
    List<Log> findByEmail(@Param("email") String email);
}
