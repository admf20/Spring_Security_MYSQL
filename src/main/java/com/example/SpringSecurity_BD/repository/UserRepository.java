package com.example.SpringSecurity_BD.repository;

import com.example.SpringSecurity_BD.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> finByPassword(String password);
}
