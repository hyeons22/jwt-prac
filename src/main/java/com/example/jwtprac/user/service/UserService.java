package com.example.jwtprac.user.service;

import com.example.jwtprac.auth.dto.request.SigninRequestDto;
import com.example.jwtprac.user.dto.response.UserOnlyEmailResponseDto;
import com.example.jwtprac.user.dto.response.UserResponseDto;
import com.example.jwtprac.user.entity.User;
import com.example.jwtprac.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto save(String email, String password) {

        // 존재하면 가입 x
        if (userRepository.existsByEmail(email)) {
            throw new IllegalStateException("가입된 이메일이 있습니다.");
        }

        // 존재하지 않는 이메일이므로 가입가능
        User user = new User(email, password);
        User savedUser = userRepository.save(user);
        return new UserResponseDto(savedUser.getId(), savedUser.getEmail(), savedUser.getPassword());
    }

    @Transactional
    public UserResponseDto findByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 유저")
        );
        return new UserResponseDto(user.getId(), user.getEmail(), user.getPassword());
    }


    public List<UserOnlyEmailResponseDto> findAll() {
        List<User> users = userRepository.findAll();

        List<UserOnlyEmailResponseDto> dtoList = new ArrayList<>();
        for (User user : users) {
            dtoList.add(new UserOnlyEmailResponseDto(user.getId(), user.getEmail()));
        }

        return dtoList;
    }
}
