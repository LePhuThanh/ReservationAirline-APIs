package com.practice.reservationAirline.controllers;

import com.practice.reservationAirline.entities.Flight;
import com.practice.reservationAirline.entities.Passenger;
import com.practice.reservationAirline.handlers.customExceptions.CustomException;
import com.practice.reservationAirline.payloads.requests.FlightRequest;
import com.practice.reservationAirline.payloads.requests.PassengerRequest;
import com.practice.reservationAirline.payloads.responses.DataResponse;
import com.practice.reservationAirline.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(path = "/flight")
// http://localhost:8080/flight/getFlightDetail
public class FlightController {
    //Logger manage and monitor events that occur during application runtime
    Logger logger = LoggerFactory.getLogger(FlightController.class);
    @Autowired
    @Qualifier("FlightServiceImpl")
    private FlightService flightService;

    @GetMapping(value = "/getFlightDetail")
    public ResponseEntity<DataResponse> findAllFlight(){
        List<Flight> flightList = flightService.getAllFlight();
        if(flightList.size() != 0){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new DataResponse("200","Get flight detail successfully", flightList));
        }
        throw new CustomException("404", "Not found any flight");
    }

    @PostMapping(value = "/addFlight")
    public ResponseEntity<DataResponse> addFlight(@RequestBody FlightRequest flightRequest){
        Flight addedFlight = flightService.addFlight(flightRequest);
        if(addedFlight != null){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new DataResponse("200","Add new flight successfully", addedFlight));
        }
        throw new CustomException("500", "Error when add new Flight");
    }


}
