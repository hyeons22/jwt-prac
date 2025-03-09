package com.example.jwtprac.auth.service;

import com.example.jwtprac.auth.dto.request.SigninRequestDto;
import com.example.jwtprac.auth.dto.request.SignupRequestDto;
import com.example.jwtprac.auth.dto.response.SigninResponseDto;
import com.example.jwtprac.auth.dto.response.SignupResponseDto;
import com.example.jwtprac.config.JwtUtil;
import com.example.jwtprac.user.dto.response.UserResponseDto;
import com.example.jwtprac.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtUtil jwtUtil;
    private final UserService userService;

    @Transactional
    public ResponseEntity<SignupResponseDto> signup(SignupRequestDto requestDto) {
        UserResponseDto userResponseDto = userService.save(requestDto.getEmail(), requestDto.getPassword());

        String bearJwt = jwtUtil.createToken(userResponseDto.getId(), userResponseDto.getEmail());
        return ResponseEntity.ok(new SignupResponseDto(bearJwt));
    }

    @Transactional(readOnly = true)
    public ResponseEntity<SigninResponseDto> signin(SigninRequestDto requestDto) {
        // 비밀번호 검증 필요
        UserResponseDto userResponseDto = userService.findByEmail(requestDto.getEmail());

        if (!requestDto.getPassword().equals(userResponseDto.getPassword())){
            throw new IllegalStateException("비밀번호가 일치하지 않습니다.");
        }

        String bearJwt = jwtUtil.createToken(userResponseDto.getId(), userResponseDto.getEmail());
        return ResponseEntity.ok(new SigninResponseDto(bearJwt));
    }
}
