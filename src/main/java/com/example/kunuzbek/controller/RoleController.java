package com.example.kunuzbek.controller;

import com.example.kunuzbek.pyload.ApiResponse;
import com.example.kunuzbek.pyload.RoleDto;
import com.example.kunuzbek.pyload.UserDto;
import com.example.kunuzbek.service.AuthService;
import com.example.kunuzbek.service.RoleService;
import com.example.kunuzbek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    private  final RoleService roleService;

    @Autowired
    public RoleController( RoleService roleService) {

        this.roleService = roleService;
    }

    @PostMapping("/addRole")
    public ResponseEntity addRole(@Valid @RequestBody RoleDto roleDto){
        ApiResponse apiResponse = roleService.addrole(roleDto);
        return ResponseEntity.status(apiResponse.isSuccess()? 200:409).body(apiResponse);

    }

}
