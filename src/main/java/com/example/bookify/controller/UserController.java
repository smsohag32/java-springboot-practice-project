package com.example.bookify.controller;

import com.example.bookify.dto.UserRequest;
import com.example.bookify.dto.UserResponse;
import com.example.bookify.response.ApiResponse;
import com.example.bookify.response.ApiResponseBuilder;
import com.example.bookify.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<ApiResponse<UserResponse>> createUser(@RequestBody UserRequest request) {
        UserResponse saveData = userService.createUser(request);
        return ApiResponseBuilder.created(saveData, "User added successfully");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<UserResponse>> updateUser(@RequestBody UserRequest request, @PathVariable Long id) {
        UserResponse saveData = userService.updateUser(request, id);
        return ApiResponseBuilder.created(saveData, "User updated successfully");
    }
    @GetMapping("/all")
    public  ResponseEntity<ApiResponse<List<UserResponse>>> getAllUsers() {
        List<UserResponse> saveData = userService.getAllUsers();
        return ApiResponseBuilder.success(saveData, "Users retrieved successfully");
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponse>> getUserById(@PathVariable Long id) {
        UserResponse saveData = userService.getUserById(id);
        return ApiResponseBuilder.success(saveData, "User retrieved successfully");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<String>> deleteUser(@PathVariable Long id) {
        String saveData = userService.deleteUser(id);
        return ApiResponseBuilder.success(saveData, "User deleted successfully");
    }
    @PutMapping("/status/{id}")
    public ResponseEntity<ApiResponse<String>> statusUpdate(@PathVariable Long id) {
        String saveData = userService.statusUpdate(id);
        return ApiResponseBuilder.success(saveData, "Status updated successfully");
    }
}
