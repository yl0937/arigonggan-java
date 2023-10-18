package com.goorm.arigonggan.controller;

import com.goorm.arigonggan.common.response.ResponseUtil;
import com.goorm.arigonggan.common.response.SuccessResponse;
import com.goorm.arigonggan.controller.dto.SeatRequest;
import com.goorm.arigonggan.domain.seat.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class SeatController {
    private final SeatService seatService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/seat/status")
    public SuccessResponse<String> seatStatus(@RequestBody @Valid SeatRequest seatRequest) {
        String status = seatService.getSeatStatus(seatRequest);
        return ResponseUtil.success(status);
    }
}
