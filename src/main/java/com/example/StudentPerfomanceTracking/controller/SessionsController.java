package com.example.StudentPerfomanceTracking.controller;

import com.example.StudentPerfomanceTracking.entity.User;
import com.example.StudentPerfomanceTracking.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sessions")
public class SessionsController {
    @Autowired
    UsersService usersService;

    @PostMapping("/")
    public ResponseEntity<?> registerUser(@Validated @RequestBody User user) {
        ResponseEntity<?> response = usersService.registerUser(user);
        return response;
    }
}
