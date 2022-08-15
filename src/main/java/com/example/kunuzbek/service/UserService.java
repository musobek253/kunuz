package com.example.kunuzbek.service;

import com.example.kunuzbek.pyload.ApiResponse;
import com.example.kunuzbek.pyload.UserDto;
import com.example.kunuzbek.repo.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final   UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ApiResponse addUser(UserDto userDto) {
        return null;
    }
}
