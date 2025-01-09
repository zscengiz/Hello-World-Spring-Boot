package com.example.hello_world.controller;

import com.example.hello_world.dto.DtoUser;
import com.example.hello_world.entity.RootEntity;
import com.example.hello_world.jwt.dto.AuthRequest;
import com.example.hello_world.jwt.dto.AuthResponse;
import com.example.hello_world.jwt.dto.RefreshTokenRequest;
import org.springframework.web.bind.annotation.PostMapping;

public interface IRestAuthController {
    public RootEntity<DtoUser> register(AuthRequest authRequest);

    @PostMapping("/authenticate")
    public RootEntity<AuthResponse> authenticate(AuthRequest authRequest);

    public AuthResponse refresh(RefreshTokenRequest request);
}
