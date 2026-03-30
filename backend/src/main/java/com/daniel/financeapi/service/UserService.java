package com.daniel.financeapi.service;

import org.springframework.stereotype.Service;

import com.daniel.financeapi.UserRepository;
import com.daniel.financeapi.model.User;
import com.daniel.financeapi.security.JwtUtil;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService {
    private final UserRepository repository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final JwtUtil jwtUtil;
    public UserService(UserRepository repository, JwtUtil jwtUtil) {
        this.repository = repository;
        this.jwtUtil = jwtUtil;
    }

    //Login and authentication
    public String login(String email, String password) {
        User user = repository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("Email not found."));

        if(!passwordEncoder.matches(password, user.getPassword())) {
            throw new IllegalArgumentException("Invalid password.");
        }
        return jwtUtil.generateToken(user.getEmail());  
    }



    // Registration
    public User registerUser(User user) {
        if (repository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email is already in use.");
        }
        user.setPassword (passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }
}
