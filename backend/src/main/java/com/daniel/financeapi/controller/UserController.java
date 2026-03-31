package com.daniel.financeapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.financeapi.model.LoginRequest;
import com.daniel.financeapi.model.User;
import com.daniel.financeapi.service.UserService;

import jakarta.validation.Valid;

@CrossOrigin(origins = {"https://personalfinancemanagerfrontend-production.up.railway.app", "https://organic-broccoli-59prrvq9pvq3v5xq-3000.app.github.dev"})
@RestController
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/register") 
    public ResponseEntity<User> registerUser(@Valid @RequestBody User user) {
        User registeredUser = userService.registerUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
    }       
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.login(request.getEmail(), request.getPassword()));
    }

}