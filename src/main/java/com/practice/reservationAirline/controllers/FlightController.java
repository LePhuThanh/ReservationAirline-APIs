package com.practice.reservationAirline.controllers;

import com.practice.reservationAirline.entities.Flight;
import com.practice.reservationAirline.entities.Passenger;
import com.practice.reservationAirline.handlers.customExceptions.CustomException;
import com.practice.reservationAirline.payloads.requests.FlightRequest;
import com.practice.reservationAirline.payloads.requests.PassengerRequest;
import com.practice.reservationAirline.payloads.responses.DataResponse;
import com.practice.reservationAirline.services.FlightService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    @PostMapping(value = "/insertFlight")
    public ResponseEntity<DataResponse> insertFlight(@RequestBody FlightRequest flightRequest){
        Flight addedFlight = flightService.insertFlight(flightRequest);
        if(addedFlight != null){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new DataResponse("200","Add new flight successfully", addedFlight));
        }
        throw new CustomException("500", "Error when add new Flight");
    }
    @GetMapping(value = "/getFlightByDate")
    public ResponseEntity<DataResponse> findFlightByDate(@PathParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        List<Flight> flightByDateList = flightService.getFlightsByDate(date);
        if(flightByDateList.size() !=0){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new DataResponse("200","Get flight by date successfully", flightByDateList));
        }
        throw new CustomException("404", "Not found any flight");
    }
    @GetMapping(value = "/getFlightByDepDes")
    public ResponseEntity<DataResponse> findFlightByDepDes(@PathParam("departure") String departure,
                                                           @PathParam("destination") String destination){
        List<Flight> flightByDepDesList = flightService.getFlightsByDepartDestination(departure, destination);
        if(flightByDepDesList.size() !=0){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new DataResponse("200","Get flight by departure destination successfully", flightByDepDesList));
        }
        throw new CustomException("404", "Not found any flight");
    }
    @PutMapping(value = "/updateFlight")
    public ResponseEntity<DataResponse> updateFlight(@RequestBody FlightRequest newFlight){
        Flight updatedFlight = flightService.updateFlight(newFlight);
        if(updatedFlight != null){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new DataResponse("200","Update flight successfully", updatedFlight));
        }
        throw new CustomException("500", "Error when update Flight");
    }
    @DeleteMapping(value = "/deleteFlight")    public ResponseEntity<DataResponse> deleteFlightByDate(@PathParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        Boolean DeletedFlightList = flightService.deleteFlight(date);
        if(!DeletedFlightList){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new DataResponse("200","Delete flight successfully"));
        }
        throw new CustomException("404", "Don't find any flights with the same departure date and have not been cancelled");
    }

}
