package com.example.StudentPerfomanceTracking.service.impl;

import com.example.StudentPerfomanceTracking.dao.RolesRepository;
import com.example.StudentPerfomanceTracking.dao.StudentsRepository;
import com.example.StudentPerfomanceTracking.dao.UsersRepository;
import com.example.StudentPerfomanceTracking.dto.LoginDTO;
import com.example.StudentPerfomanceTracking.dto.RegisterDTO;
import com.example.StudentPerfomanceTracking.dto.UserLoginDTO;
import com.example.StudentPerfomanceTracking.entity.Role;
import com.example.StudentPerfomanceTracking.entity.Student;
import com.example.StudentPerfomanceTracking.entity.User;
import com.example.StudentPerfomanceTracking.security.jwt.AuthResponse;
import com.example.StudentPerfomanceTracking.security.jwt.JwtUntils;
import com.example.StudentPerfomanceTracking.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    RolesRepository rolesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUntils jwtUntils;

    @Autowired
    private StudentsRepository studentsRepository;

    @Override
    public ResponseEntity<?> registerUser(RegisterDTO registerDTO) {
        if(usersRepository.existsByUsername(registerDTO.getUsername())) {
            return ResponseEntity.badRequest().body(new Error("Username that already exist"));
        }

        if(usersRepository.existsByEmail(registerDTO.getEmail())) {
            return ResponseEntity.badRequest().body(new Error("Email that already exist"));
        }

        String roleName = "ROLE_" + registerDTO.getRole().toUpperCase();
        Role role = rolesRepository.findByName(roleName)
                .orElseThrow(() -> new RuntimeException("Invalid role: " + registerDTO.getRole()));

        User user = new User();
        user.setUsername(registerDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        user.setEmail(registerDTO.getEmail());
        user.setPhoneNumber(registerDTO.getPhoneNumber());
        user.setRole(role);
        saveUser(user);

        if(registerDTO.getRole().equalsIgnoreCase("LEARNER")) {
            Student student = new Student(registerDTO.getEmail(), user);
            studentsRepository.save(student);
        }
        return ResponseEntity.ok("Successful Account Registration");
    }

    @Override
    public User saveUser(User user) {
        return usersRepository.save(user);
    }

    @Override
    public AuthResponse loginUser(LoginDTO loginDTO) {
        String msg = "";
        User user1 = usersRepository.findByUsername(loginDTO.getUsername());

        if (user1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user = usersRepository.findOneByUsernameAndPassword(loginDTO.getUsername(), encodedPassword);
                if (user.isPresent()) {
                    Role role = rolesRepository.findById(usersRepository.findRoleIdByUsername(loginDTO.getUsername()));
                    String token = jwtUntils.generateToken(loginDTO.getUsername(), role.getName(), user1.getId());
                    UserLoginDTO userLoginDTO = new UserLoginDTO(user1.getId(), loginDTO.getUsername(), role.getId());
                    return new AuthResponse(token, true, userLoginDTO);
                } else {
                    return new AuthResponse("Login Failed", false);
                }
            } else {
                return new AuthResponse("password Not Match", false);
            }
        }else {
            return new AuthResponse("Username not exits", false);
        }
    }

}
