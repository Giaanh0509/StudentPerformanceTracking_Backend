package com.example.StudentPerfomanceTracking.controller;

import com.example.StudentPerfomanceTracking.dto.LoginDTO;
import com.example.StudentPerfomanceTracking.dto.RegisterDTO;
import com.example.StudentPerfomanceTracking.entity.User;
import com.example.StudentPerfomanceTracking.security.jwt.AuthResponse;
import com.example.StudentPerfomanceTracking.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/sessions")
public class SessionsController {
    @Autowired
    UsersService usersService;

    @PostMapping("/")
    public ResponseEntity<?> registerUser(@RequestBody RegisterDTO RegisterDTO) {
        ResponseEntity<?> response = usersService.registerUser(RegisterDTO);
        return response;
    }

    @PostMapping("/login")
    public AuthResponse loginUser(@RequestBody LoginDTO loginDTO) {
        AuthResponse loginResponse = usersService.loginUser(loginDTO);
        return loginResponse;
    }
}
