package com.example.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.model.UserDto;
import com.example.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	// http://localhost:8080/api/users
	@PostMapping
	public UserDto createUser(@RequestBody UserDto user) {

		return userService.createUser(user);
	}

	// http://localhost:8080/api/users/1
	@GetMapping("/{id}")
	public UserDto getUserById(@PathVariable Long id) {

		return userService.getUserById(id);
	}

	// http://localhost:8080/api/users
	@GetMapping
	public List<UserDto> getAllUsers() {

		return userService.getAllUsers();
	}

	// http://localhost:8080/api/users/1
	@PutMapping("/{id}")
	public UserDto updateUser(@PathVariable Long id, @RequestBody UserDto user) {

		user.setId(id);
		return userService.updateUser(user);
	}

	// http://localhost:8080/api/users/1
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {

		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
}