package com.example.bookify.service;

import com.example.bookify.dto.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;

    public LoginResponse login(String username, String password) {
        return userService.login(username, password);
    }
}
