package com.example.jwtprac.auth.controller;

import com.example.jwtprac.annotation.Auth;
import com.example.jwtprac.auth.dto.request.SigninRequestDto;
import com.example.jwtprac.auth.dto.request.SignupRequestDto;
import com.example.jwtprac.auth.dto.response.SigninResponseDto;
import com.example.jwtprac.auth.dto.response.SignupResponseDto;
import com.example.jwtprac.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/auth/signup")
    public ResponseEntity<SignupResponseDto> signup (@RequestBody SignupRequestDto requestDto) {
        return authService.signup(requestDto);
    }

    @PostMapping("/auth/signin")
    public ResponseEntity<SigninResponseDto> signin (@RequestBody SigninRequestDto requestDto) {
        return authService.signin(requestDto);
    }

}
