package com.practice.reservationAirline.repositories;

import com.practice.reservationAirline.entities.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories
public interface AirlineRepository extends JpaRepository<Airline, Integer> {
    Airline findAirlineByAirlineNumber(Integer airlineNumber);
}
