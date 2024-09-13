package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    
    public User createUser(String key, String value, List<String> roles) {
        User user = new User(key, value, roles);
        return userRepository.save(user);
    }

    public Optional<User> updateUser(String key, String value, String role) {
        Optional<User> existingUser = userRepository.findByKey(key);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setValue(value);
            ((List<String>) user.getRoles()).add(role);  // Update roles
            userRepository.save(user);
            return Optional.of(user);
        }
        return Optional.empty();
    }
    
    public boolean deleteUserByKey(String key) {
        Optional<User> user = userRepository.findByKey(key);
        if (user.isPresent()) {
            userRepository.deleteByKey(key);
            return true;
        }
        return false;
    }
    
    public List<String> getUserRoles(String key) {
        Optional<User> user = userRepository.findByKey(key);
        return (List<String>) user.map(User::getRoles).orElse(null);
    }
}
