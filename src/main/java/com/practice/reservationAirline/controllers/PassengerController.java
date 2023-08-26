package com.practice.reservationAirline.controllers;


import com.practice.reservationAirline.entities.Passenger;
import com.practice.reservationAirline.handlers.customExceptions.CustomException;
import com.practice.reservationAirline.payloads.requests.PassengerRequest;
import com.practice.reservationAirline.services.PassengerService;
import com.practice.reservationAirline.payloads.responses.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<DataResponse> getAllPassenger(){
        List<Passenger> passenger = passengerService.getAllPassenger();
        if(!passenger.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                new DataResponse("200", "Get all passenger successfully", passenger));
        }
            throw new CustomException("404", "Not found any passengers");
    }
    @GetMapping(value = "/getPassengerByPassport/{passport}")
    public ResponseEntity<DataResponse> getPassengerByPassport(@PathVariable String passport){
        List <Passenger> passengerByPassport = passengerService.getPassengerByPassport(passport);
        if(!passengerByPassport.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                new DataResponse ("200","Get passenger by passport successfully",passengerByPassport));
        }
        throw new CustomException("500", "Passenger is not found");
    }

    @GetMapping(value = "/getPassengerByPaymentCardNumber/{paymentCardNumber}")
    public ResponseEntity<DataResponse> getPassengerByPaymentCardNumber(@PathVariable String paymentCardNumber){
        List<Passenger> passengerByPaymentCardNumber = passengerService.getPassengerByPaymentCardNumber(paymentCardNumber);
        if(!passengerByPaymentCardNumber.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                new DataResponse ("200","Get passenger by payment card number successfully", passengerByPaymentCardNumber));
        }
        throw new CustomException("500", "Passenger is not found");
    }
    @GetMapping(value = "/getPassengerByUserId/{userId}")
    public ResponseEntity<DataResponse> getPassengerByUserId(@PathVariable Integer userId){
        List<Passenger> passengerByUserId = passengerService.getPassengerByUserId(userId);
        if(!passengerByUserId.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                new DataResponse ("200", "Get passenger by user id successfully", passengerByUserId));
        }
        throw new CustomException("500", "Passenger is not found");
    }

    @GetMapping(value = "/getPassengerById/{passengerId}")
    public ResponseEntity<DataResponse> getPassengerById(@PathVariable Integer passengerId){
        Passenger passengerById = passengerService.getPassengerById(passengerId);
        if(passengerById != null) {
            return ResponseEntity.status(HttpStatus.OK).body(
                new DataResponse ("200", "Get passenger by id successfully", passengerById));
        }
        throw new CustomException("500", "Passenger is not found");
    }

    //POST
    //employee
    @PostMapping(value = "/insertNewPassenger", consumes = "application/json;charset=UTF-8") // add ticket
    public ResponseEntity<DataResponse> addTicket(@RequestBody PassengerRequest passengerRequest) {
        Passenger passengerAddTicket = passengerService.insertNewPassenger(passengerRequest);
        if(passengerAddTicket != null) {
            return ResponseEntity.status(HttpStatus.OK).body(
                new DataResponse("200","Insert new passenger successfully", passengerAddTicket));
        }
        throw new CustomException("500", "Insert passenger failed");
    }
    //

    //DELETE
    @DeleteMapping(value = "/deletePassengerById/{passengerId}") // delete ticket
    public ResponseEntity<DataResponse> deletePassengerById (@PathVariable Integer passengerId) {
        Boolean isDeletePassenger = passengerService.deletePassengerById(passengerId);
        if (isDeletePassenger) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new DataResponse("200", "Delete the passenger successfully", ""));
        }
           throw new CustomException("500", "Delete passenger failed");
    }
    //UPDATE
    @PutMapping(value = "/updatePassenger")
    public ResponseEntity<DataResponse> updatePassenger(@RequestBody PassengerRequest passengerRequest) {
        Passenger updatePassenger = passengerService.updatePassenger(passengerRequest);
        if(updatePassenger != null) {
            return ResponseEntity.status(HttpStatus.OK).body(
                new DataResponse("200", "Update the passenger successfully", updatePassenger));
        }
        throw new CustomException("500", "Update the passenger failed");
    }

}
