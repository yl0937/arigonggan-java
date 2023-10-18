package com.goorm.arigonggan.controller;

import com.goorm.arigonggan.common.response.ResponseUtil;
import com.goorm.arigonggan.common.response.SuccessResponse;
import com.goorm.arigonggan.controller.dto.SeatRequest;
import com.goorm.arigonggan.controller.dto.SeatResponse;
import com.goorm.arigonggan.domain.seat.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class SeatController {
    private final SeatService seatService;

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/seat/status")
    public SuccessResponse<String> seatStatus(@RequestBody @Valid SeatRequest seatRequest) {
        String status = seatService.getSeatStatus(seatRequest);
        return ResponseUtil.success(status);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/all")
    public SuccessResponse<List<SeatResponse>> seatStatus() {
        List<SeatResponse> seatList = seatService.getAllSeatStatus();
        return ResponseUtil.success(seatList);
    }
}
