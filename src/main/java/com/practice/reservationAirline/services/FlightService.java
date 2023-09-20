package com.practice.reservationAirline.services;

import com.practice.reservationAirline.entities.Flight;
import com.practice.reservationAirline.payloads.requests.FlightRequest;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface FlightService {
    public Flight insertFlight(FlightRequest flightRequest);
    public List<Flight> getAllFlight();
    public List<Flight> getFlightsByDate(Date date);

    public List<Flight> getFlightsByDepartDestination(String departure, String destination);
    public Flight updateFlight(Flight newFlight, String flightNumber);
    public Boolean deleteFlight(Date date);

}
