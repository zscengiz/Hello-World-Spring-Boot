package com.example.hello_world.controller.impl;
import com.example.hello_world.controller.IUserController;
import com.example.hello_world.dto.DtoUser;
import com.example.hello_world.entity.User;
import com.example.hello_world.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping("/rest/api/user")
public class UserControllerImpl implements IUserController {

    @Autowired
    private IUserService userService;

    @PostMapping(path = "/save")
    @Override
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping(path="/list")
    @Override
    public List<DtoUser> getAllUsers() {
        return userService.getAllUser();
    }

}
