package com.goorm.arigonggan.domain.reservation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.time.LocalDateTime;

@Component
@EnableScheduling
@Slf4j
@RequiredArgsConstructor
public class ReservationSchedule {

    private final ReservationService reservationService;

    @Scheduled(cron = "0 50 8-17 * * *")
    public void prebookedReservation() {
        Time time = Time.valueOf((LocalDateTime.now()).toLocalTime().plusMinutes(10));
        reservationService.prebookedReservation(time);
    }
}
