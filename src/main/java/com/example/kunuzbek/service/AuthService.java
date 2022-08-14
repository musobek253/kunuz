package com.example.kunuzbek.service;

import com.example.kunuzbek.entity.User;
import com.example.kunuzbek.pyload.ApiResponse;
import com.example.kunuzbek.pyload.RegisterDto;
import com.example.kunuzbek.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    final UserRepository userRepository;

    @Autowired
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ApiResponse registerUser(RegisterDto registerDto) {
        if (userRepository.existsByUsername(registerDto.getUsername()))
            return new ApiResponse("Alreadey exist by username",false);
        return new ApiResponse("salom",true);
    }
}
