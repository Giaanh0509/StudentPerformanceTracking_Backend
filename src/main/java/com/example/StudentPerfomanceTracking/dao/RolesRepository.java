package com.example.StudentPerfomanceTracking.dao;

import com.example.StudentPerfomanceTracking.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface RolesRepository extends JpaRepository<Role, Integer> {

}
