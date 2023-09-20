package com.practice.reservationAirline.services.Impl;

import com.practice.reservationAirline.entities.Flight;
import com.practice.reservationAirline.entities.Passenger;
import com.practice.reservationAirline.handlers.customExceptions.CustomException;
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
    public Flight updateFlight(Flight newFlight, String flightNumber) {
        Flight updatedFlight = flightRepository.findById(flightNumber)
                .map(flight -> { //Have => mapping all value update new information
//                    flight.setAirlineNumber(newFlight.getAirlineNumber());
                    flight.setDestination(newFlight.getDestination());
                    flight.setDeparture(newFlight.getDeparture());
                    flight.setDepartureDate(newFlight.getDepartureDate());
                    flight.setDepartureTime(newFlight.getDepartureTime());
                    flight.setArrivalDate(newFlight.getArrivalDate());
                    flight.setIsCancel(newFlight.getIsCancel());
                    return flightRepository.save(flight);
                }).orElseGet(() -> { //Don't have -> save new flight
                    newFlight.setFlightNumber(flightNumber);
                    return flightRepository.save(newFlight);
                });
        return  updatedFlight; // Returns updated flights or new flights.
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
