package com.example.hello_world.services;

import com.example.hello_world.dto.DtoUser;
import com.example.hello_world.jwt.dto.AuthRequest;
import com.example.hello_world.jwt.dto.AuthResponse;
import com.example.hello_world.jwt.dto.RefreshTokenRequest;

public interface IAuthService {
    public DtoUser register(AuthRequest authRequest);
    public AuthResponse authenticate(AuthRequest authRequest);

}
