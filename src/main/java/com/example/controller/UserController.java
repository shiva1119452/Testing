package com.example.controller;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.model.UserDto;
import com.example.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

	private final UserService userService;

	// http://localhost:8080/api/users
	@PostMapping
	public UserDto createUser(@RequestBody UserDto user) {
		log.info("Creating user: {}", user);
		return userService.createUser(user);
	}

	// http://localhost:8080/api/users/1
	@GetMapping("/{id}")
	public UserDto getUserById(@PathVariable Long id) {
		log.info("Fetching user with id: {}", id);
		return userService.getUserById(id);
	}

	// http://localhost:8080/api/users
	@GetMapping
	public List<UserDto> getAllUsers() {
		log.info("Fetching all users");
		return userService.getAllUsers();
	}

	// http://localhost:8080/api/users/1
	@PutMapping("/{id}")
	public UserDto updateUser(@PathVariable Long id, @RequestBody UserDto user) {
		log.info("Updating user with id: {}", id);
		user.setId(id);
		return userService.updateUser(user);
	}

	// http://localhost:8080/api/users/1
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		log.info("Deleting user with id: {}", id);
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
}