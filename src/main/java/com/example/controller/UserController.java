package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;

@RestController
@RequestMapping("/userservice")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@GetMapping("/status")
	public String status() {
		return "user Service is up and running!";
	}

	// private Map<String, String> dataStore = new HashMap<>();

	@GetMapping("/data")
	public ResponseEntity<List<User>> getData() {
		List<User> users = userRepository.findAll();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@PostMapping("/data")
	public ResponseEntity<User> createData(@RequestParam String key, @RequestParam String value,
			@RequestParam List<String> roles) {
		User user = userService.createUser(key, value, roles);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	@PutMapping("/data")
	public ResponseEntity<String> updateData(@RequestParam String key, @RequestParam String value,
			@RequestParam String role) {
		Optional<User> updatedUser = userService.updateUser(key, value, role);
		return updatedUser.isPresent() ? new ResponseEntity<>("Data updated", HttpStatus.OK)
				: new ResponseEntity<>("Key not found", HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/data")
	public ResponseEntity<String> deleteData(@RequestParam String key) {
		Optional<User> existingUser = userRepository.findByKey(key);
		if (existingUser.isPresent()) {
			userRepository.deleteByKey(key);
			return new ResponseEntity<>("Data deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Key not found", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/roles")
	public ResponseEntity<List<String>> getUserRoles(@RequestParam String key) {
		List<String> roles = userService.getUserRoles(key);
		return new ResponseEntity<>(roles, HttpStatus.OK);
	}

//    public ResponseEntity<String> getUser(@PathVariable String userId) {
//        // Simulate fetching user information
//        return ResponseEntity.ok("User info for userId: " + userId);
//    }
}
