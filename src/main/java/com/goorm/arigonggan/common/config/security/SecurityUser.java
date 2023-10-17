package com.goorm.arigonggan.common.config.security;

import com.goorm.arigonggan.domain.user.User;
import org.springframework.security.core.authority.AuthorityUtils;

public class SecurityUser extends org.springframework.security.core.userdetails.User {    // 스프링 시큐리티 인증용 객체

    public SecurityUser(User user) {
        super(String.valueOf(user.getId()), "",
                AuthorityUtils.createAuthorityList("ROLE_USER"));
    }
}
