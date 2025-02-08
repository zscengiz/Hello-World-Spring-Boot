package com.example.hello_world.jwt.impl;

import com.example.hello_world.entity.AccessToken;
import com.example.hello_world.jwt.IJwtService;
import com.example.hello_world.repository.AccessTokenRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtServiceImpl implements IJwtService {
    @Value("${jwt.secretKey}") //vm options
    private String secretKey;

    @Value("${jwt.expirationTime}")
    private Long expirationTime;

    @Autowired
    private AccessTokenRepository accessTokenRepository;

    @Override
    public String generateToken(UserDetails userDetails) {

        Map<String, Object> claimsMap = new HashMap<>();
        claimsMap.put("role", userDetails.getAuthorities());

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .addClaims(claimsMap) //.set claims yanlış
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(getKey())
                .compact();
    }

    @Override
    public Claims getClaimsFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token).getBody();
        return claims;
    }

    public Object getClaimsByKey(String token, String key) {
        Claims claims = getClaimsFromToken(token);
        return claims.get(key);
    }
    @Override
    public <T> T exportToken(String token, Function<Claims, T> claimsResolver) {
        Claims claims = getClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    @Override
    public String getUsernameByToken(String token) {
        return exportToken(token, Claims::getSubject);
    }
    @Override
    public boolean isTokenExpired(String token) {
        Date expireDate = exportToken(token, Claims::getExpiration);
        return new Date().after(expireDate);
    }

    @Override
    public void allTokenPassiveFromUserId(Long userId) {
        accessTokenRepository.updateAccessToken(userId);

    }

    @Override
    public boolean isTokenValid(String token, String username) {
        String usernameFromToken = exportToken(token, Claims::getSubject);
        return (username.equals(usernameFromToken) && !isTokenExpired(token));
    }

    @Override
    public Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    @Override
    public AccessToken findByAccessToken(String token) {
        return accessTokenRepository.findByAccessToken(token).orElse(null);
    }

    @Override
    public AccessToken saveAccessToken(AccessToken accessToken) {
        return accessTokenRepository.save(accessToken);
    }

}