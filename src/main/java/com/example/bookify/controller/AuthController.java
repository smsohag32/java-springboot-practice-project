package com.example.bookify.controller;

import com.example.bookify.dto.LoginResponse;
import com.example.bookify.response.ApiResponse;
import com.example.bookify.response.ApiResponseBuilder;
import com.example.bookify.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController


@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping
    public ApiResponse<LoginResponse> login(String username, String password) {
        return ApiResponseBuilder.success(authService.login(username, password), "Login Successful").getBody();
    }
}
