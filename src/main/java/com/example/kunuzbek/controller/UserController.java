package com.example.kunuzbek.controller;

import com.example.kunuzbek.pyload.ApiResponse;
import com.example.kunuzbek.pyload.UserDto;
import com.example.kunuzbek.service.AuthService;
import com.example.kunuzbek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final AuthService authService;
    private  final UserService userService;

    @Autowired
    public UserController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @PostMapping("/AddUser")
    public ResponseEntity registerUser(@Valid @RequestBody UserDto userDto){
        ApiResponse apiResponse = userService.addUser(userDto);
        return ResponseEntity.status(apiResponse.isSuccess()? 200:409).body(apiResponse);

    }

}
