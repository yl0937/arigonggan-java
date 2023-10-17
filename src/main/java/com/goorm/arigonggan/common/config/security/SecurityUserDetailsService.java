package com.goorm.arigonggan.common.config.security;

import com.goorm.arigonggan.common.exception.BaseException;
import com.goorm.arigonggan.domain.user.User;
import com.goorm.arigonggan.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import static com.goorm.arigonggan.common.exception.ErrorCode.USER_NOT_FOUND;

@RequiredArgsConstructor
@Service
public class SecurityUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) {
        User user = userRepository.findById(Long.parseLong(userId))
                .orElseThrow(() -> new BaseException(USER_NOT_FOUND, "userId=" + userId));

        return new SecurityUser(user);
    }

}