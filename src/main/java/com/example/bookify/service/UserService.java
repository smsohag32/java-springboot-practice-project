package com.example.bookify.service;

import com.example.bookify.dto.LoginResponse;
import com.example.bookify.dto.UserRequest;
import com.example.bookify.dto.UserResponse;
import com.example.bookify.entity.User;
import com.example.bookify.enums.Role;
import com.example.bookify.repositories.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserResponse createUser(UserRequest request) {

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setAddress(request.getAddress());
        user.setRole(request.getRole());
        user.setStatus(true);
        return mapToResponse(userRepository.save(user));
    }




    public UserResponse updateUser(UserRequest request, Long id) {
        User user = userRepository.findById(id).orElseThrow(null);
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setRole(request.getRole());
        user.setPhone(request.getPhone());
        user.setAddress(request.getAddress());
        return mapToResponse(userRepository.save(user));
    }
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream().map(this::mapToResponse).toList();
    }

    public UserResponse getUserById(Long id) {
        return mapToResponse(userRepository.findById(id).orElseThrow(null));
    }
    public String deleteUser (Long id) {
        userRepository.deleteById(id);
        return "Deleted Successfully";
    }

    public String statusUpdate(Long id) {
        User user = userRepository.findById(id).orElseThrow(null);
        user.setStatus(!user.getStatus());
        userRepository.save(user);
        return "Status Updated";
    }



    private UserResponse mapToResponse(User save) {
        return UserResponse.builder()
                .id(save.getId())
                .username(save.getUsername())
                .email(save.getEmail())
                .phone(save.getPhone())
                .address(save.getAddress())
                .role(save.getRole())
                .build();
    }

    public LoginResponse login(String username, String password) {

        User user = (User) userRepository.findByUsernameAndPassword(username, password).orElse(null);
        assert user != null;
        return LoginResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .phone(user.getPhone())
                .address(user.getAddress())
                .role(user.getRole())
                .token(null)
                .refreshToken(null)
                .message("Login Successful")
                .build();
    }
}
