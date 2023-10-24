package com.goorm.arigonggan.domain.reservation;

import com.goorm.arigonggan.common.exception.BaseException;
import com.goorm.arigonggan.common.exception.ErrorCode;
import com.goorm.arigonggan.controller.dto.SeatRequest;
import com.goorm.arigonggan.domain.seat.Seat;
import com.goorm.arigonggan.domain.seat.SeatRepository;
import com.goorm.arigonggan.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Time;

@RequiredArgsConstructor
@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final SeatRepository seatRepository;
    private final UserRepository userRepository;

    public void addReservation(Long userId, SeatRequest seatRequest) {
        if (!userRepository.existsById(userId)) throw new BaseException(ErrorCode.USER_NOT_FOUND);
        Seat seat = seatRepository.findByFloorAndNameAndTime(seatRequest.getFloor(), seatRequest.getName(),
                Time.valueOf(seatRequest.getTime())).orElseThrow((()->new BaseException(ErrorCode.USER_NOT_FOUND)));
        if (!(seat.getStatus()).equals("activate")) {
            throw new BaseException((ErrorCode.USER_NOT_FOUND));
        }
        reservationRepository.save(Reservation.from(userId, seat.getId(), "deactivation"));
    }
}