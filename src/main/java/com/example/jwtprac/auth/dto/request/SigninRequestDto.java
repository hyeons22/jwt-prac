package com.example.jwtprac.auth.dto.request;

import lombok.Getter;

@Getter
public class SigninRequestDto {

    private String email;

    private String password;
}
