package com.practice.reservationAirline.repositories;

import com.practice.reservationAirline.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, String> {
    Flight findByFlightNumber(String flightNumber);
    List<Flight> findByDepartureDateAndIsCancel(Date departureDate, Boolean isCancel);
    List<Flight> findByDepartureLikeAndDestinationLikeAndIsCancel(String departure, String destination, Boolean isCancel);


}
