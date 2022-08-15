package com.example.kunuzbek.controller;

import com.example.kunuzbek.entity.User;
import com.example.kunuzbek.pyload.ApiResponse;
import com.example.kunuzbek.pyload.LoginDto;
import com.example.kunuzbek.pyload.RegisterDto;
import com.example.kunuzbek.security.JwtProvayder;
import com.example.kunuzbek.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;
    private final AuthenticationManager authenticationManager;
    private final JwtProvayder jwtProvayder;

    public AuthController(AuthService authService, AuthenticationManager authenticationManager, JwtProvayder jwtProvayder) {
        this.authService = authService;
        this.authenticationManager = authenticationManager;
        this.jwtProvayder = jwtProvayder;
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@Valid @RequestBody RegisterDto registerDto){
        ApiResponse apiResponse = authService.registerUser(registerDto);
        return ResponseEntity.status(apiResponse.isSuccess()? 200:409).body(apiResponse);

    }
    @PostMapping("/login")
    public ResponseEntity registerUser(@Valid @RequestBody LoginDto loginDto){
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
        User user = (User)authenticate.getPrincipal();
        String token = jwtProvayder.generateToken(user.getRole(), user.getUsername());
        return ResponseEntity.ok(token);

    }

}
