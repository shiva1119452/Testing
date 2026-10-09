package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.UserDto;
import com.example.repository.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    public UserDto createUser(UserDto user) {
        userMapper.save(user);
        return user;
    }

    public UserDto getUserById(Long id) {
        return userMapper.findById(id);
    }

    public List<UserDto> getAllUsers() {
        return userMapper.findAll();
    }

    public UserDto updateUser(UserDto user) {
        userMapper.update(user);
        return user;
    }

    public void deleteUser(Long id) {
        userMapper.deleteById(id);
    }
}