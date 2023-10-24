package com.goorm.arigonggan.domain.reservation;

import com.goorm.arigonggan.common.exception.BaseException;
import com.goorm.arigonggan.common.exception.ErrorCode;
import com.goorm.arigonggan.controller.dto.SeatRequest;
import com.goorm.arigonggan.domain.seat.Seat;
import com.goorm.arigonggan.domain.seat.SeatRepository;
import com.goorm.arigonggan.domain.user.User;
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
        if (!userRepository.existsById(userId))
            throw new BaseException(ErrorCode.USER_NOT_FOUND);
        Seat seat = seatRepository.findByFloorAndNameAndTime(seatRequest.getFloor(), seatRequest.getName(),
                Time.valueOf(seatRequest.getTime())).orElseThrow((() -> new BaseException(ErrorCode.SEAT_NOT_FOUND)));
        if (!(seat.getStatus()).equals("activate")) {
            throw new BaseException((ErrorCode.DISABLE_SEAT));
        }
        reservationRepository.save(Reservation.from(userId, seat.getId(), "deactivation"));
    }

    public void deleteReservation(Long userId, SeatRequest seatRequest) {
        // 없는 회원
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BaseException(ErrorCode.USER_NOT_FOUND));
        // 없는 좌석
        Seat seat = seatRepository.findByFloorAndNameAndTime(seatRequest.getFloor(), seatRequest.getName(),
                Time.valueOf(seatRequest.getTime())).orElseThrow((() -> new BaseException(ErrorCode.SEAT_NOT_FOUND)));
        // 없는 예약
        Reservation reservation = reservationRepository.findBySeatIdAndUserId(seat.getId(),user.getId())
                .orElseThrow(() -> new BaseException(ErrorCode.RESERVATION_NOT_FOUND));
        // 취소 불가 좌석
        if ((reservation.getStatus()).equals("prebooked") || (reservation.getStatus()).equals("canceled")) throw new BaseException(ErrorCode.NOT_POSSIBLE_CANCELLATION);
        reservation.updateStatus("deleted");
        reservationRepository.save(reservation);
    }
}
