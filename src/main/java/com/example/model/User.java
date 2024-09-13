package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.github.andrewoma.dexx.collection.List;

@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String key;
    private String value;
    private List<String> roles;

    // Constructors, getters, and setters
    public User() {}

    public User(String key, String value,java.util.List<String> roles2) {
        this.key = key;
        this.value = value;
        this.roles = roles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
    
    
}

