package com.example.demo;


import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByKey(String key);
    void deleteByKey(String key);
}

