package com.example.StudentPerfomanceTracking.dao;

import com.example.StudentPerfomanceTracking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {
}