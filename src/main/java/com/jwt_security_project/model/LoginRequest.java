package com.jwt_security_project.model;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
