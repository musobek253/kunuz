package com.example.kunuzbek.repo;

import com.example.kunuzbek.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(String rolName);
    boolean existsByName(String name);
}