// src/main/java/com/example/bookMS/service/UserServiceImpl.java
package com.example.bookMS.service;

import com.example.bookMS.model.LoginRequest;
import com.example.bookMS.model.SignupRequest;
import com.example.bookMS.model.User;
import com.example.bookMS.model.UserResponse;
import com.example.bookMS.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponse signup(SignupRequest request) {
        // 이미 존재하는 아이디인지 확인
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
        }

        // 새 유저 생성
        User user = User.builder()
                .username(request.getUsername())
                .password(request.getPassword()) // ⚠️ 실서비스면 암호화 필요
                .build();

        User saved = userRepository.save(user);

        return UserResponse.builder()
                .id(saved.getId())
                .username(saved.getUsername())
                .build();
    }

    @Override
    public UserResponse login(LoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 아이디입니다."));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 올바르지 않습니다.");
        }

        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();
    }
}
