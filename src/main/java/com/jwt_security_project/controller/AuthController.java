package com.jwt_security_project.controller;

import com.jwt_security_project.model.AppUser;
import com.jwt_security_project.model.JwtResponse;
import com.jwt_security_project.model.LoginRequest;
import com.jwt_security_project.service.AppUserService;
import com.jwt_security_project.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AppUserService appUserService;
    private final JwtService jwtService;

    public AuthController(AppUserService appUserService, JwtService jwtService) {
        this.appUserService = appUserService;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public String register(@RequestBody AppUser user) {
        appUserService.registerUser(user);
        return "User registered successfully";
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest loginRequest) {
        String token = jwtService.generateToken(loginRequest.getUsername(), loginRequest.getPassword());
        return ResponseEntity.ok(new JwtResponse(token));
    }
}
