package com.goorm.arigonggan.domain.seat;

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
public class SeatSchedule {

    private final SeatService seatService;
    @Scheduled(cron = "0 0 9-18 * * *")
    public void updateSeatDisableEveryH() {
        Time time = Time.valueOf(LocalDateTime.now().toLocalTime());
        seatService.updateSeatDisable(time);
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void updateSeatActivateEveryD() {
        seatService.updateSeatActivate();
    }
}
