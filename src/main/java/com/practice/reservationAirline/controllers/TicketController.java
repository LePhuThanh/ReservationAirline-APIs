package com.practice.reservationAirline.controllers;

import com.practice.reservationAirline.entities.Passenger;
import com.practice.reservationAirline.entities.Ticket;
import com.practice.reservationAirline.handlers.customExceptions.CustomException;
import com.practice.reservationAirline.payloads.requests.TicketRequest;
import com.practice.reservationAirline.payloads.responses.DataResponse;
import com.practice.reservationAirline.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(path = "/ticket")
public class TicketController {
    @Autowired
    @Qualifier("TicketServiceImpl")
    private TicketService ticketService;

    @GetMapping(value = "/getAllTickets")
    public ResponseEntity<DataResponse> getAllTicket(){
        List<Ticket> ticketList = ticketService.getAllTickets();
        if(ticketList.size() > 0) {
            return ResponseEntity.status(HttpStatus.OK).body(
                new DataResponse("200", "Get all ticket successfully", ticketList));
        }
            throw new CustomException("404","Not found any tickets");
    }
    @GetMapping(value = "/getTicketById/{id}")
    public ResponseEntity<DataResponse> getTicketById(@PathVariable Integer id){
        Ticket ticketById = ticketService.getTicketById(id);
        if(ticketById != null) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new DataResponse("200", "Get ticket by ID successfully", ticketById));
        }
        throw new CustomException("500","Ticket is not found");
    }
    @PostMapping(value = "/insertTicket")
    public ResponseEntity<DataResponse> insertTicket(@RequestBody TicketRequest ticketRequest){
        Ticket insertTicket = ticketService.insertTicket(ticketRequest);
        if(insertTicket != null) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new DataResponse("200", "Insert ticket successfully", insertTicket));
        }
        throw new CustomException("500","Insert ticket failed");
    }

    @GetMapping(value = "/getTicketsByUserId/{id}")
    public ResponseEntity<DataResponse> getTicketsByUserId(@PathVariable Integer id){
        List<Ticket> ticketByUserId = ticketService.getTicketsByUserId(id);
        if(ticketByUserId.size() > 0) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new DataResponse("200", "Get ticket by User ID successfully", ticketByUserId));
        }
        throw new CustomException("500","Ticket is not found");
    }
    @GetMapping(value = "/getTicketsBySeatNumber/{id}")
    public ResponseEntity<DataResponse> getTicketsBySeatNumber(@PathVariable Integer id){
        Ticket ticketBySeatNumber = ticketService.getTicketsBySeatNumber(id);
        if(ticketBySeatNumber != null) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new DataResponse("200", "Get ticket by seat number successfully", ticketBySeatNumber));
        }
        throw new CustomException("500","Ticket is not found");
    }
    @GetMapping(value = "/getTicketsByFlightNumber/{id}")
    public ResponseEntity<DataResponse> getTicketsByFlightNumber(@PathVariable String id){
        List<Ticket> ticketsByFlightNumber = ticketService.getTicketsByFlightNumber(id);
        if(ticketsByFlightNumber.size() > 0) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new DataResponse("200", "Get ticket by flight number successfully", ticketsByFlightNumber));
        }
        throw new CustomException("500","Ticket is not found");
    }


}
