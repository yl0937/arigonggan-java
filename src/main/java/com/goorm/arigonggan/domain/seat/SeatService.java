package com.goorm.arigonggan.domain.seat;

import com.goorm.arigonggan.common.exception.BaseException;
import com.goorm.arigonggan.common.exception.ErrorCode;
import com.goorm.arigonggan.controller.dto.SeatRequest;
import com.goorm.arigonggan.controller.dto.SeatResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SeatService {

    private final SeatRepository seatRepository;

    public String getSeatStatus(SeatRequest seatRequest) {

        Seat seat = seatRepository.findByFloorAndNameAndTime(
                        seatRequest.getFloor(), seatRequest.getName(), Time.valueOf(seatRequest.getTime()))
                .orElseThrow(() -> new BaseException(ErrorCode.USER_NOT_FOUND));
        updateSeatDisable(Time.valueOf("10:00:00"));
        return seat.getStatus();
    }

    public List<SeatResponse> getAllSeatStatus() {
        List<Seat> seatList = seatRepository.findAll();
        return seatList.stream().map(SeatResponse::fromSeat).collect(Collectors.toList());
    }

    public List<Seat> getSeatInfo(Time time) {
        return seatRepository.findByTime(time);
    }

    public void updateSeatDisable(Time time) {
        List<Seat> seatList = getSeatInfo(time);
        for (Seat seat : seatList) {
            seat.updateSeatStatus("disable");
        }
        seatRepository.saveAll(seatList);
    }

    public void updateSeatBooked(Seat seat) {
        seat.updateSeatStatus("booked");
        seatRepository.save(seat);
    }

    public void updateSeatActivate() {
        List<Seat> seatList = seatRepository.findAll();
        for (Seat seat : seatList) {
            seat.updateSeatStatus("activate");
        }
        seatRepository.saveAll(seatList);
    }

}
