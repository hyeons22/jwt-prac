package com.example.jwtprac.auth.dto.response;

import lombok.Getter;

@Getter
public class SignupResponseDto {

    private final String bearerJwt;

    public SignupResponseDto(String bearerJwt) {
        this.bearerJwt = bearerJwt;
    }
}
