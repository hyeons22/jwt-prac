package com.example.jwtprac.auth.dto.request;

import lombok.Getter;

@Getter
public class SignupRequestDto {

    private String email;

    private String password;
}
