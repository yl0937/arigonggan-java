package com.goorm.arigonggan.domain.user;

import com.goorm.arigonggan.controller.dto.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public User signUp(UserRequest userRequest) {
        return User.from(userRequest);
    }
}
