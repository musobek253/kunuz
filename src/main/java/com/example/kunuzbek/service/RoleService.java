package com.example.kunuzbek.service;

import com.example.kunuzbek.entity.Role;
import com.example.kunuzbek.pyload.ApiResponse;
import com.example.kunuzbek.pyload.RoleDto;
import com.example.kunuzbek.repo.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class RoleService {
    @Autowired(required = false)
    private RoleRepository roleRepository;



    public ApiResponse addrole(RoleDto roleDto) {
        if (roleRepository.existsByName(roleDto.getName()))
            return new ApiResponse("Already existBy name",false);
        Role role = new Role(
                roleDto.getName(),
                roleDto.getHuquqList()
        );
        Role newRole = roleRepository.save(role);
        return  new ApiResponse("Successfully added  role",true);
    }
}
