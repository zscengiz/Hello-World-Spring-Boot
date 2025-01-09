package com.example.hello_world.jwt;

import com.example.hello_world.entity.RefreshToken;
import com.example.hello_world.jwt.dto.AuthResponse;
import com.example.hello_world.jwt.dto.RefreshTokenRequest;

public interface IRefreshTokenService {

    public AuthResponse refreshToken(RefreshTokenRequest request);


}
