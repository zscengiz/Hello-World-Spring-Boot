package com.example.hello_world.controller.impl;

import com.example.hello_world.controller.IRestAuthController;
import com.example.hello_world.controller.RestBaseController;
import com.example.hello_world.dto.DtoUser;
import com.example.hello_world.entity.RootEntity;
import com.example.hello_world.jwt.IRefreshTokenService;
import com.example.hello_world.jwt.dto.AuthRequest;
import com.example.hello_world.jwt.dto.AuthResponse;
import com.example.hello_world.jwt.dto.RefreshTokenRequest;
import com.example.hello_world.services.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@RestController
@RequestMapping("api/auth")
public class RestAuthControllerImpl extends RestBaseController implements IRestAuthController {

    @Autowired
    private IRefreshTokenService refreshTokenService;

    @Autowired
    private IAuthService authService;

    @PostMapping("/register")
    @Override
    public RootEntity<DtoUser> register(@Valid @RequestBody AuthRequest authRequest){

        return ok(authService.register(authRequest));
    }

    @PostMapping("/authenticate")
    @Override
    public RootEntity<AuthResponse> authenticate(@RequestBody AuthRequest authRequest) {
        return ok(authService.authenticate(authRequest));
    }

    @PostMapping("/refreshToken")
    @Override
    public AuthResponse refresh(@RequestBody RefreshTokenRequest request) {
        return refreshTokenService.refreshToken(request);

    }

}
