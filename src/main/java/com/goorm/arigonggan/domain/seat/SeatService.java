package com.goorm.arigonggan.domain.seat;

import com.goorm.arigonggan.common.exception.BaseException;
import com.goorm.arigonggan.common.exception.ErrorCode;
import com.goorm.arigonggan.controller.dto.SeatRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Time;

@RequiredArgsConstructor
@Service
public class SeatService {

    private final SeatRepository seatRepository;

    public String getSeatStatus(SeatRequest seatRequest) {

        Seat seat = seatRepository.findByFloorAndNameAndTime(
                seatRequest.getFloor(),seatRequest.getName(),Time.valueOf(seatRequest.getTime()))
                .orElseThrow(()-> new BaseException(ErrorCode.USER_NOT_FOUND));
        return seat.getStatus();
    }
}
