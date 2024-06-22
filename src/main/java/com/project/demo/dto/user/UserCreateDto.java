package com.project.demo.dto.user;

import javax.management.relation.Role;

import lombok.Data;

@Data
public class UserCreateDto {
    
    private String firstName;

    private String lastName;

    private String email;

    private Role role;
    
    private String password;
}
