package com.example.bookify.dto;

import com.example.bookify.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserRequest {
    private String username;
    private String password;
    private String email;
    private String phone;
    private String address;
    private Role role;
}
