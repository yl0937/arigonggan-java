package com.goorm.arigonggan.domain.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Optional<Reservation> findBySeatIdAndUserId(Long seatId, Long userId);

    List<Reservation> findAllBySeatTimeAndStatus(Time seatTime, String status);
}
