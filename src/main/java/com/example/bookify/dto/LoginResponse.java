package com.example.bookify.dto;

import com.example.bookify.enums.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginResponse {
    private Long id;
    private String token;
    private String refreshToken;
    private String message;
    private String username;
    private String email;
    private Role role;
    private String phone;
    private String address;

}
