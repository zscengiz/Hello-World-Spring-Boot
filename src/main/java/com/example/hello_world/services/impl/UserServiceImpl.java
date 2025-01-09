package com.example.hello_world.services.impl;
import com.example.hello_world.dto.DtoUser;
import com.example.hello_world.entity.User;
import com.example.hello_world.repository.UserRepository;
import com.example.hello_world.services.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<DtoUser> getAllUser(){
        List<DtoUser> dtoList = new ArrayList<>();
        List<User> userList = userRepository.findAll();
        for (User user : userList) {
            DtoUser dtoUser = new DtoUser();
            BeanUtils.copyProperties(user,dtoUser);
            dtoList.add(dtoUser);
        }
        return dtoList;
    }


}
