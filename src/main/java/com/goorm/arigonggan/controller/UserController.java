package com.goorm.arigonggan.controller;

import com.goorm.arigonggan.common.jwt.JwtProvider;
import com.goorm.arigonggan.common.jwt.TokenDto;
import com.goorm.arigonggan.common.response.ResponseUtil;
import com.goorm.arigonggan.controller.dto.TokenResponse;
import com.goorm.arigonggan.controller.dto.UserRequest;
import com.goorm.arigonggan.common.response.SuccessResponse;
import com.goorm.arigonggan.domain.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    private final JwtProvider jwtProvider;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("logIn")
    public SuccessResponse<?> signUp(@RequestBody @Valid UserRequest userRequest) {
        Long userId = userService.signIn(userRequest);
        TokenDto accessToken = jwtProvider.generateAccessToken(userId);
        return ResponseUtil.success(TokenResponse.fromAccessToken(accessToken));
    }

}
