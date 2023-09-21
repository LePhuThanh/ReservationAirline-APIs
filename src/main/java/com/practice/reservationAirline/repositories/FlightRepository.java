package com.practice.reservationAirline.repositories;

import com.practice.reservationAirline.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;
import java.util.List;

@EnableJpaRepositories
public interface FlightRepository extends JpaRepository<Flight, String> {
    Flight findByFlightNumber(String flightNumber);
    List<Flight> findByDepartureDateAndIsCancel(Date departureDate, Boolean isCancel);
    List<Flight> findByDepartureLikeAndDestinationLikeAndIsCancel(String departure, String destination, Boolean isCancel);


}
