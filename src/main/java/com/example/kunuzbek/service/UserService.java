package com.example.kunuzbek.service;

import com.example.kunuzbek.pyload.ApiResponse;
import com.example.kunuzbek.pyload.UserDto;
import com.example.kunuzbek.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired(required = false)
    private UserRepository userRepository;

    public ApiResponse addUser(UserDto userDto) {
        return null;
    }
}
