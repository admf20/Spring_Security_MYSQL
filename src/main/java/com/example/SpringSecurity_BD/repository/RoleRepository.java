package com.example.SpringSecurity_BD.repository;

import com.example.SpringSecurity_BD.model.Role;
import com.example.SpringSecurity_BD.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
