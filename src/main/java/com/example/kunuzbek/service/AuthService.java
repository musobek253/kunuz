package com.example.kunuzbek.service;


import com.example.kunuzbek.entity.User;
import com.example.kunuzbek.exeptions.ResourceNotFound;
import com.example.kunuzbek.pyload.ApiResponse;

import com.example.kunuzbek.pyload.Appconstantis;
import com.example.kunuzbek.pyload.RegisterDto;
import com.example.kunuzbek.repo.RoleRepository;
import com.example.kunuzbek.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class AuthService implements UserDetailsService {
    @Autowired(required = false)
    private UserRepository userRepository;
    @Autowired(required = false)
    private  RoleRepository roleRepository;
    @Autowired(required = false)
    private  PasswordEncoder passwordEncoder;


    public ApiResponse registerUser(RegisterDto registerDto) {
        if (!registerDto.getPassword().equals(registerDto.getPrePassword()))
            return new ApiResponse("parollar mos emas",false);
        if (userRepository.existsByUsername(registerDto.getUsername()))
            return new ApiResponse("Already exist by username",false);
        User user = new User(
                registerDto.getFullName(),
                registerDto.getUsername(),
                passwordEncoder.encode(registerDto.getPassword()),
                true,
                roleRepository.findByName(Appconstantis.USER).orElseThrow(()->new ResourceNotFound("role","name",Appconstantis.USER)));
        userRepository.save(user);
        return new ApiResponse("Successfully added",true);
    }

    public UserDetails loadUserByUsername(String userName) {
     return userRepository.findByUsername(userName).orElseThrow(()-> new UsernameNotFoundException(userName));
    }
}
