package com.example.kunuzbek.repo;

import com.example.kunuzbek.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsByUsername(String username);// bu user
    Optional<User> findByUsername(String username);
}