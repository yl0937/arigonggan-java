package com.goorm.arigonggan.controller.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SeatRequest {
    @NotBlank
    private String floor;
    @NotBlank
    private String name;
    @NotBlank
    private String time;
}
