package com.practice.reservationAirline.services.Impl;

import com.practice.reservationAirline.entities.*;
import com.practice.reservationAirline.handlers.customExceptions.CustomException;
import com.practice.reservationAirline.payloads.requests.FlightRequest;
import com.practice.reservationAirline.payloads.requests.PassengerRequest;
import com.practice.reservationAirline.repositories.AirlineRepository;
import com.practice.reservationAirline.repositories.FlightRepository;
import com.practice.reservationAirline.repositories.TicketRepository;
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
    @Autowired
    private TicketRepository ticketRepository;

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

    public Flight insertFlight(FlightRequest flightRequest) {
        Flight foundFlight = flightRepository.findByFlightNumber(flightRequest.getFlightNumber());
        if(foundFlight == null) {
            return flightRepository.save(assignValueToFlight(new Flight(), flightRequest));
        }
        throw new CustomException("500", "Flight Number Already Taken");
//        Flight flight = new Flight();
//        flight = assignValueToFlight(flight,flightRequest);
//        return flightRepository.save(flight);

    }

    @Override
    public List<Flight> getAllFlight(){
        return flightRepository.findAll();
    }

    @Override
    public List<Flight> getFlightsByDate(Date date) {
        return flightRepository.findByDepartureDateAndIsCancel(date, false);
    }

    @Override
    public List<Flight> getFlightsByDepartDestination(String departure, String destination) {
        return flightRepository.findByDepartureLikeAndDestinationLikeAndIsCancel(departure, destination, false);
    }

    @Override
    public Flight updateFlight(FlightRequest newFlight) {
        Flight existFlight = flightRepository.findById(newFlight.getFlightNumber()).orElse(null);
        if(existFlight != null) {
            Airline Airline = airlineRepository.findAirlineByAirlineNumber(newFlight.getAirlineNumber());
            existFlight.setDestination(newFlight.getDestination());
            existFlight.setDeparture(newFlight.getDeparture());
            existFlight.setDepartureDate(newFlight.getDepartureDate());
            existFlight.setDepartureTime(newFlight.getDepartureTime());
            existFlight.setArrivalDate(newFlight.getArrivalDate());
            existFlight.setAirlineNumber(Airline);
            return flightRepository.save(existFlight);
        }
        throw new CustomException("404", "Not found flight");
    }

    //Delete all flights with the same departure date and have not been canceled
    @Override
    public Boolean deleteFlight(Date date) {
        List<Flight> matchDateFlights = flightRepository.findByDepartureDateAndIsCancel(date, false);
        if(matchDateFlights.size() > 0) {
            for (Flight flight : matchDateFlights) {
                flightRepository.delete(flight);
            }
            return true;
        }
        return false;
    }
}
