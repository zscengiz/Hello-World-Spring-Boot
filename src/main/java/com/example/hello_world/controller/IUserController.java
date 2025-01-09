package com.example.hello_world.controller;

import com.example.hello_world.dto.DtoUser;
import com.example.hello_world.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public interface IUserController  {
    public User saveUser(User user);
    public List<DtoUser> getAllUsers();

}
