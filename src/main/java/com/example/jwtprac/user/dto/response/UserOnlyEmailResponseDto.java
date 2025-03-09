package com.example.jwtprac.user.dto.response;

import lombok.Getter;

@Getter
public class UserOnlyEmailResponseDto {

    private final Long id;

    private final String email;

    public UserOnlyEmailResponseDto(Long id, String email) {
        this.id = id;
        this.email = email;
    }
}
