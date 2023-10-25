package com.goorm.arigonggan.controller;

import com.goorm.arigonggan.common.response.ResponseUtil;
import com.goorm.arigonggan.common.response.SuccessResponse;
import com.goorm.arigonggan.controller.dto.SeatRequest;
import com.goorm.arigonggan.domain.reservation.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
public class ReservationController {

    private final ReservationService reservationService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/reservation")
    public SuccessResponse<?> seatStatus(@AuthenticationPrincipal Long userId,
                                              @RequestBody @Valid SeatRequest seatRequest) {
        reservationService.addReservation(userId,seatRequest);
        return ResponseUtil.success();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping("/reservation")
    public SuccessResponse<?> deleteReservation(@AuthenticationPrincipal Long userId,
                                         @RequestBody @Valid SeatRequest seatRequest) {
        reservationService.deleteReservation(userId,seatRequest);
        return ResponseUtil.success();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PatchMapping("/booked")
    public SuccessResponse<?> bookReservation(@AuthenticationPrincipal Long userId,
                                              @RequestBody @Valid SeatRequest seatRequest) {
        reservationService.bookReservation(userId,seatRequest);
        return ResponseUtil.success();
    }
}
