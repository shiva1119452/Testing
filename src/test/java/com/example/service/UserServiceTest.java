package com.example.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.model.UserDto;
import com.example.repository.UserMapper;

class UserServiceTest {

    private UserMapper userMapper;
    private UserService userService;

    @BeforeEach
    void setUp() {
        userMapper = mock(UserMapper.class);
        userService = new UserService(userMapper);
    }

    @Test
    void createUserSavesAndReturnsUser() {
        UserDto user = user(1L);

        UserDto result = userService.createUser(user);

        assertSame(user, result);
        verify(userMapper).save(user);
    }

    @Test
    void getUserByIdReturnsMapperResult() {
        UserDto expected = user(1L);
        when(userMapper.findById(1L)).thenReturn(expected);

        UserDto result = userService.getUserById(1L);

        assertSame(expected, result);
        verify(userMapper).findById(1L);
    }

    @Test
    void getAllUsersReturnsMapperResults() {
        List<UserDto> expected = List.of(user(1L), user(2L));
        when(userMapper.findAll()).thenReturn(expected);

        List<UserDto> result = userService.getAllUsers();

        assertSame(expected, result);
        verify(userMapper).findAll();
    }

    @Test
    void updateUserUpdatesAndReturnsUser() {
        UserDto user = user(1L);

        UserDto result = userService.updateUser(user);

        assertSame(user, result);
        verify(userMapper).update(user);
    }

    @Test
    void deleteUserDeletesById() {
        userService.deleteUser(1L);

        verify(userMapper).deleteById(1L);
    }

    private UserDto user(Long id) {
        UserDto user = new UserDto();
        user.setId(id);
        user.setName("User " + id);
        user.setEmail("user" + id + "@example.com");
        user.setAge(30);
        return user;
    }
}
