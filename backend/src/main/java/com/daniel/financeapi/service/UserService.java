package com.daniel.financeapi.service;

import org.springframework.stereotype.Service;

import com.daniel.financeapi.UserRepository;
import com.daniel.financeapi.model.User;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService {
    private final UserRepository repository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public UserService(UserRepository repository) {
        this.repository = repository;
    }
    public User registerUser(User user) {
        if (repository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email is already in use.");
        }
        user.setPassword (passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }
}
