package com.practice.reservationAirline.repositories;

import com.practice.reservationAirline.entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface SeatRepository extends JpaRepository<Seat, Integer> {
    Seat findBySeatNumber(Integer seatNumber);
}
