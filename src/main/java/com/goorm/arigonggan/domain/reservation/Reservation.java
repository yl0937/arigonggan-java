package com.goorm.arigonggan.domain.reservation;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Time;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long seatId;
    private String status;
    private Time seatTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static Reservation from(Long user, Long seatId, Time seatTime, String status) {
        return Reservation.builder()
                .userId(user)
                .seatId(seatId)
                .status(status)
                .seatTime(seatTime)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public void updateStatus(String status) {
        this.status = status;
    }
}
