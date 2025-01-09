package com.example.hello_world.dto;
import com.example.hello_world.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoUser {
    private String username;
    private Role role;
}