package com.example.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.model.UserDto;
import com.example.service.UserService;

class UserControllerTest {

    private UserService userService;
    private UserController userController;

    @BeforeEach
    void setUp() {
        userService = mock(UserService.class);
        userController = new UserController(userService);
    }

    @Test
    void createUserDelegatesToService() {
        UserDto user = user(1L);
        when(userService.createUser(user)).thenReturn(user);

        UserDto result = userController.createUser(user);

        assertSame(user, result);
        verify(userService).createUser(user);
    }

    @Test
    void getUserByIdDelegatesToService() {
        UserDto expected = user(1L);
        when(userService.getUserById(1L)).thenReturn(expected);

        UserDto result = userController.getUserById(1L);

        assertSame(expected, result);
        verify(userService).getUserById(1L);
    }

    @Test
    void getAllUsersDelegatesToService() {
        List<UserDto> expected = List.of(user(1L), user(2L));
        when(userService.getAllUsers()).thenReturn(expected);

        List<UserDto> result = userController.getAllUsers();

        assertSame(expected, result);
        verify(userService).getAllUsers();
    }

    @Test
    void updateUserUsesPathIdInsteadOfRequestBodyId() {
        UserDto user = user(99L);
        when(userService.updateUser(user)).thenReturn(user);

        UserDto result = userController.updateUser(1L, user);

        assertSame(user, result);
        assertEquals(1L, user.getId());
        verify(userService).updateUser(user);
    }

    @Test
    void deleteUserReturnsNoContentAndDelegatesToService() {
        ResponseEntity<Void> result = userController.deleteUser(1L);

        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
        assertNull(result.getBody());
        verify(userService).deleteUser(1L);
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
