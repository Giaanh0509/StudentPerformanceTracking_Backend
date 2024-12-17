package com.example.StudentPerfomanceTracking.dao;

import com.example.StudentPerfomanceTracking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RepositoryRestResource
public interface UsersRepository extends JpaRepository<User, Integer> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    Optional<User> findOneByUsernameAndPassword(String username, String password);
    User findByUsername(String username);
    User findById(int id);
    @Query("SELECT u.role.id FROM User u WHERE u.username = :username")
    int findRoleIdByUsername(String username);
}
