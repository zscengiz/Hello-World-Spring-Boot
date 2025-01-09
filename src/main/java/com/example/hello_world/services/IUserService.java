package com.example.hello_world.services;

import com.example.hello_world.dto.DtoUser;
import com.example.hello_world.entity.User;

import java.util.List;

public interface IUserService {
    public User saveUser(User user);

    public List<DtoUser> getAllUser();
}
