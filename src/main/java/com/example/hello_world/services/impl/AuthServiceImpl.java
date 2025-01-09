package com.example.hello_world.services.impl;

import com.example.hello_world.dto.DtoUser;
import com.example.hello_world.entity.AccessToken;
import com.example.hello_world.entity.RefreshToken;
import com.example.hello_world.entity.Role;
import com.example.hello_world.entity.User;
import com.example.hello_world.exception.BaseException;
import com.example.hello_world.exception.ErrorMessage;
import com.example.hello_world.exception.MessageType;
import com.example.hello_world.jwt.IJwtService;
import com.example.hello_world.jwt.IRefreshTokenService;
import com.example.hello_world.jwt.dto.AuthRequest;
import com.example.hello_world.jwt.dto.AuthResponse;
import com.example.hello_world.jwt.dto.RefreshTokenRequest;
import com.example.hello_world.repository.RefreshTokenRepository;
import com.example.hello_world.repository.UserRepository;
import com.example.hello_world.services.IAuthService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private IJwtService jwtService;

    @Autowired
    private IRefreshTokenService refreshTokenService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private RefreshTokenRepository refreshTokenRepository;


    private RefreshToken createRefreshToken(User user) {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setExpireDate(new Date(System.currentTimeMillis() + 1000*60*60*4));
        refreshToken.setRefreshToken(UUID.randomUUID().toString());
        refreshToken.setUser(user);
        return refreshToken;

    }

    @Override
    public AuthResponse authenticate(AuthRequest authRequest) {
        try{

            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());

            authenticationProvider.authenticate(authentication);

            Optional<User> optionalUser = userRepository.findByUsername(authRequest.getUsername());
            if (!optionalUser.isPresent()) {
                throw new UsernameNotFoundException("User not found: " + authRequest.getUsername());
            }
            User user = optionalUser.get();

            AccessToken accessTokenObj = new AccessToken();
            accessTokenObj.setAccessToken(jwtService.generateToken(user));
            accessTokenObj.setUser(user);
            String accessToken = jwtService.saveAccessToken(accessTokenObj).getAccessToken();

            RefreshToken refreshToken = createRefreshToken(optionalUser.get());
            refreshTokenRepository.save(createRefreshToken(optionalUser.get()));

            return new AuthResponse(accessToken,refreshToken.getRefreshToken());

        }catch (Exception e){
            throw new BaseException(new ErrorMessage(MessageType.USERNAME_OR_PASSWORD_INVALID, e.getMessage()));

        }
    }


    @Override
    public DtoUser register(AuthRequest authRequest) {

        DtoUser dtoUser = new DtoUser();
        User user = new User();
        user.setUsername(authRequest.getUsername());

        user.setUsername(authRequest.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(authRequest.getPassword()));
        user.setRole(Role.USER);

        User savedUser = userRepository.save(user);
        BeanUtils.copyProperties(savedUser, dtoUser);
        dtoUser.setRole(savedUser.getRole());

        return dtoUser;
    }


}
