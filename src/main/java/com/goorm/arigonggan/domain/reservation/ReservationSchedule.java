package com.goorm.arigonggan.domain.reservation;

import com.goorm.arigonggan.domain.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;

@Component
@EnableScheduling
@Slf4j
@RequiredArgsConstructor
public class ReservationSchedule {

    private final ReservationService reservationService;
    private final UserService userService;

    @Scheduled(cron = "0 50 8-17 * * *")
    public void prebookReservation() {
        Time time = Time.valueOf((LocalDateTime.now()).toLocalTime().plusMinutes(10));
        reservationService.updateReservationStatus(time,"deactivation","prebooked");
    }

    @Scheduled(cron = "0 10 9-18 * * *")
    public void cancelReservation() {
        Time time = Time.valueOf((LocalDateTime.now()).toLocalTime().minusMinutes(10));
        List<Long> userList = reservationService.updateReservationStatus(time,"prebooked","canceled");
        userService.updateUserDisable(userList);
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void activateUser() {
        userService.updateUserActivate();
    }
}
