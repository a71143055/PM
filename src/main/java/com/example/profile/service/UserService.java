package com.example.profile.service;

import com.example.profile.model.User;
import com.example.profile.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // 회원가입
    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // 암호화
        return userRepository.save(user);
    }

    // 사용자 조회
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
