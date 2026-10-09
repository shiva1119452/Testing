package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.model.UserDto;

@Mapper
public interface UserMapper {

    void save(UserDto user);

    UserDto findById(Long id);

    List<UserDto> findAll();

    void update(UserDto user);

    void deleteById(Long id);
}