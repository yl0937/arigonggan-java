package com.goorm.arigonggan.domain.user;

import com.goorm.arigonggan.controller.dto.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public Long signIn(UserRequest userRequest) {
        if (!userRepository.existsByStudentNum(userRequest.getStudentNum())) {
            signUp(userRequest);
        }
        User user = userRepository.findByStudentNum(userRequest.getStudentNum());
        return user.getId();
    }

    public void signUp(UserRequest userRequest) {
        userRepository.save(User.from(userRequest));
    }
}
