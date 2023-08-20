package com.practice.reservationAirline.controllers;


import com.practice.reservationAirline.entities.Passenger;
import com.practice.reservationAirline.handlers.CustomException;
import com.practice.reservationAirline.payloads.requests.PassengerRequest;
import com.practice.reservationAirline.repositories.PassengerRepository;
import com.practice.reservationAirline.services.PassengerService;
import com.practice.reservationAirline.payloads.responses.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Passenger")
public class PassengerController {
    @Autowired
    @Qualifier("PassengerServiceImpl")
    private PassengerService passengerService;

    //GET
    //localhost:8080/Passenger/getAllPassenger
    @GetMapping(value = "/getAllPassenger")
    public DataResponse getAllPassenger(){
        List<Passenger> passenger = passengerService.getAllPassenger();
        if(passenger.size() == 0) {
            throw new CustomException("404", "Not found any passengers");
        }
        return new DataResponse("200", passenger ,"Get all passenger successfully");
    }
    @GetMapping(value = "/getPassengerByPassport/{passport}")
    public DataResponse getPassengerByPassport(@PathVariable String passport){
        List <Passenger> passengerByPassport = passengerService.getPassengerByPassport(passport);
        if(passengerByPassport.size() == 0) {
            throw new CustomException("500", "Passenger is not found");
        }
        return new DataResponse ("200",passengerByPassport,"Get passenger by passport successfully");
    }
    @GetMapping(value = "/getPassengerByPaymentCardNumber/{paymentCardNumber}")
    public DataResponse getPassengerByPaymentCardNumber(@PathVariable String paymentCardNumber){
        List<Passenger> passengerByPaymentCardNumber = passengerService.getPassengerByPaymentCardNumber(paymentCardNumber);
        if(passengerByPaymentCardNumber.size() == 0) {
            throw new CustomException("500", "Passenger is not found");
        }
           return new DataResponse("200", passengerByPaymentCardNumber,"Get passenger by payment card number successfully");
    }
    @GetMapping(value = "/getPassengerByUserId/{userId}")
    public DataResponse getPassengerByUserId(@PathVariable Integer userId){
        List<Passenger> passengerByUserId = passengerService.getPassengerByUserId(userId);
        if(passengerByUserId.size() == 0) {
            throw new CustomException("500","Passenger is not found");
        }
        return new DataResponse("200", passengerByUserId, "Get passenger by user id successfully");
    }

    @GetMapping(value = "/getPassengerById/{passengerId}")
    public DataResponse getPassengerById(@PathVariable Integer passengerId){
        Passenger passengerById = passengerService.getPassengerById(passengerId);
        if(passengerById == null) {
            throw new CustomException("500",  "Passenger is not found");
        }
        return new DataResponse("200",passengerById , "Get passenger by id successfully");
}

    //POST
    //employee
    @PostMapping(value = "/insertNewPassenger", consumes = "application/json;charset=UTF-8")
    public DataResponse addTicket(@RequestBody PassengerRequest passengerRequest) {
        Passenger passenger = passengerService.insertNewPassenger(passengerRequest);
        if(passenger == null){
            throw new CustomException("500", "Insert passenger Failed");
        }
        return new DataResponse("200", passenger,"Insert new passenger successfully");
    }



}
