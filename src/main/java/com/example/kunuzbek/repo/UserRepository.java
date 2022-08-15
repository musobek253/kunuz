package com.example.kunuzbek.repo;

import com.example.kunuzbek.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);// bu user
    Optional<User> findByUsername(String username);
}