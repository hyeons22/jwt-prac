package com.example.jwtprac.user.dto.response;

import lombok.Getter;

@Getter
public class UserResponseDto {

    private final Long id;

    private final String email;

    private final String password;

    public UserResponseDto(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

}
