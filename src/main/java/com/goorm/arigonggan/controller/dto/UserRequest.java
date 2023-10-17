package com.goorm.arigonggan.controller.dto;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserRequest {
    @NotBlank
    @Min(8)
    private String studentNum;
}
