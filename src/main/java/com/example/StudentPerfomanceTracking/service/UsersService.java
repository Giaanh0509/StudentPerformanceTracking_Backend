package com.example.StudentPerfomanceTracking.service;

import com.example.StudentPerfomanceTracking.entity.User;
import org.springframework.http.ResponseEntity;

public interface UsersService {
    ResponseEntity<?> registerUser(User user);

    User saveUser (User user);
}
