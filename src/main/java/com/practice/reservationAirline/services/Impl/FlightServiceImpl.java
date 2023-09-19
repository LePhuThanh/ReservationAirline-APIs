package com.practice.reservationAirline.services.Impl;

import com.practice.reservationAirline.entities.Flight;
import com.practice.reservationAirline.payloads.requests.FlightRequest;
import com.practice.reservationAirline.repositories.AirlineRepository;
import com.practice.reservationAirline.repositories.FlightRepository;
import com.practice.reservationAirline.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("FlightServiceImpl")
@Transactional
public class FlightServiceImpl implements FlightService {
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    AirlineRepository airlineRepository;

    //method assign value to flight
    public Flight assignValueToFlight(Flight flight, FlightRequest flightRequest){
        flight.setFlightNumber(flightRequest.getFlightNumber());
        flight.setDeparture(flightRequest.getDeparture());
        flight.setArrivalDate(flightRequest.getArrivalDate());
        flight.setDestination(flightRequest.getDestination());
        flight.setDepartureDate(flightRequest.getDepartureDate());
        flight.setCancel(false);
        flight.setAirlineNumber(airlineRepository.findAirlineByAirlineNumber(flightRequest.getAirlineNumber()));
        flight.setAirline_airline_number(new ArrayList<>());
        return flight;
    }

    public Flight addFlight(FlightRequest flightRequest) {
        Flight flight = new Flight();
        flight = assignValueToFlight(flight,flightRequest);
        return flightRepository.save(flight);
    }

    @Override
    public List<Flight> getAllFlight(){
        return flightRepository.findAll();
    }

    @Override
    public List<Flight> getFlightsByDate(Date date) {
        return null;
    }

    @Override
    public List<Flight> getFlightsByDepartDestination(String departure, String destinate) {
        return null;
    }

    @Override
    public Flight updateFlight(Flight flight) {
        return null;
    }

    @Override
    public List<Flight> deleteFlight(Date date) {
        return null;
    }
}
