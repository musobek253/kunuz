package com.example.kunuzbek.repo;

import com.example.kunuzbek.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {

    Optional<Role> findByName(String rolName);
    boolean existsByName(String name);
}