package com.example.jwtprac.user.controller;

import com.example.jwtprac.annotation.Auth;
import com.example.jwtprac.auth.dto.AuthUser;
import com.example.jwtprac.user.dto.response.UserOnlyEmailResponseDto;
import com.example.jwtprac.user.dto.response.UserResponseDto;
import com.example.jwtprac.user.repository.UserRepository;
import com.example.jwtprac.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserOnlyEmailResponseDto>> getUsers(@Auth AuthUser authuser) {
        return ResponseEntity.ok(userService.findAll());
    }
}
