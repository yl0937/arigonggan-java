package com.goorm.arigonggan.domain.seat;

import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    Optional<Seat> findByFloorAndNameAndTime(String floor, String name, Time time);

    List<Seat> findByTime(Time time);

}
