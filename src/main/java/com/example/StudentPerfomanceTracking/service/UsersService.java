package com.example.StudentPerfomanceTracking.service;

import com.example.StudentPerfomanceTracking.dto.LoginDTO;
import com.example.StudentPerfomanceTracking.dto.RegisterDTO;
import com.example.StudentPerfomanceTracking.entity.User;
import com.example.StudentPerfomanceTracking.security.jwt.AuthResponse;
import org.springframework.http.ResponseEntity;

public interface UsersService {
    ResponseEntity<?> registerUser(RegisterDTO registerDTO);

    User saveUser (User user);

    AuthResponse loginUser(LoginDTO loginDTO);
}
