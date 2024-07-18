package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/userservice")
public class UserController {

	@GetMapping("/status")
	public String status() {
		return "user Service is up and running!";
	}

	private Map<String, String> dataStore = new HashMap<>();

	@GetMapping("/data")
	public ResponseEntity<Map<String, String>> getData() {
		return new ResponseEntity<>(dataStore, HttpStatus.OK);
	}

	@PostMapping("/data")
	public ResponseEntity<String> createData(@RequestParam String key, @RequestParam String value) {
		dataStore.put(key, value);
		return new ResponseEntity<>("Data created", HttpStatus.CREATED);
	}

	@PutMapping("/data")
	public ResponseEntity<String> updateData(@RequestParam String key, @RequestParam String value) {
		if (dataStore.containsKey(key)) {
			dataStore.put(key, value);
			return new ResponseEntity<>("Data updated", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Key not found", HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/data")
	public ResponseEntity<String> deleteData(@RequestParam String key) {
		if (dataStore.containsKey(key)) {
			dataStore.remove(key);
			return new ResponseEntity<>("Data deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Key not found", HttpStatus.NOT_FOUND);
		}
	}

//    public ResponseEntity<String> getUser(@PathVariable String userId) {
//        // Simulate fetching user information
//        return ResponseEntity.ok("User info for userId: " + userId);
//    }
}
