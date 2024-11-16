package com.example.StudentPerfomanceTracking.service.impl;

import com.example.StudentPerfomanceTracking.dao.UsersRepository;
import com.example.StudentPerfomanceTracking.entity.User;
import com.example.StudentPerfomanceTracking.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public ResponseEntity<?> registerUser(User user) {
        if(usersRepository.existsByUsername(user.getUsername())) {
            return ResponseEntity.badRequest().body(new Error("Username that already exist"));
        }

        if(usersRepository.existsByEmail(user.getEmail())) {
            return ResponseEntity.badRequest().body(new Error("Email that already exist"));
        }

        User user_register = saveUser(user);
        return ResponseEntity.ok("Successful Account Registration");
    }

    @Override
    public User saveUser(User user) {
        return usersRepository.save(user);
    }

}
