package com.goorm.arigonggan.controller.dto;

import com.goorm.arigonggan.domain.seat.Seat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class SeatResponse {

    private String floor;
    private String name;
    private String time;
    private String status;

    public static SeatResponse fromSeat(Seat seat) {
        return SeatResponse.builder()
                .floor(seat.getFloor())
                .name(seat.getName())
                .time(seat.getTime().toString())
                .status(seat.getStatus())
                .build();
    }
}
