package com.example.hello_world.jwt.impl;

import com.example.hello_world.entity.RefreshToken;
import com.example.hello_world.entity.User;
import com.example.hello_world.jwt.IJwtService;
import com.example.hello_world.jwt.IRefreshTokenService;
import com.example.hello_world.jwt.dto.AuthResponse;
import com.example.hello_world.jwt.dto.RefreshTokenRequest;
import com.example.hello_world.repository.RefreshTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshTokenServiceImpl implements IRefreshTokenService {

    @Autowired
    private IJwtService jwtService;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    public boolean isRefreshTokenExpired(Date expiredDate) {
        return new Date().after(expiredDate);

    }
    private RefreshToken createRefreshToken(User user) {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setRefreshToken(UUID.randomUUID().toString()); // düzelt
        refreshToken.setExpireDate(new Date(System.currentTimeMillis() + 1000*60*60*4));
        refreshToken.setUser(user);
        return refreshToken;

    }

    @Override
    public AuthResponse refreshToken(RefreshTokenRequest request) {
        Optional<RefreshToken> optional = refreshTokenRepository.findByRefreshToken(request.getRefreshToken());
        if (!optional.isPresent()) {
            System.out.println("Refresh token not valid: " + request.getRefreshToken());
        }
        RefreshToken refreshToken = optional.get();
        if(isRefreshTokenExpired(refreshToken.getExpireDate())){
            String accessToken = jwtService.generateToken(refreshToken.getUser());
            return new AuthResponse(accessToken, refreshToken.getRefreshToken());
        }
        String accessToken = jwtService.generateToken(refreshToken.getUser());
//        RefreshToken newRefreshToken = createRefreshToken(refreshToken.getUser());

        RefreshToken savedRefreshToken = refreshTokenRepository.save(createRefreshToken(refreshToken.getUser()));

        return new AuthResponse(accessToken, savedRefreshToken.getRefreshToken());
    }

}
