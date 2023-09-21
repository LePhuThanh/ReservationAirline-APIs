package com.practice.reservationAirline.services.Impl;

import com.practice.reservationAirline.entities.*;
import com.practice.reservationAirline.handlers.customExceptions.CustomException;
import com.practice.reservationAirline.payloads.requests.PassengerRequest;
import com.practice.reservationAirline.payloads.requests.TicketRequest;
import com.practice.reservationAirline.repositories.FlightRepository;
import com.practice.reservationAirline.repositories.SeatRepository;
import com.practice.reservationAirline.repositories.TicketRepository;
import com.practice.reservationAirline.repositories.UserRepository;
import com.practice.reservationAirline.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("TicketServiceImpl")
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SeatRepository seatRepository;

    public Ticket assignValueToTicket(Ticket ticket, TicketRequest ticketRequest){
        ticket.setTicketId(ticketRequest.getTicketId());
        ticket.setFlightNumber(flightRepository.findByFlightNumber(ticketRequest.getFlightNumber()));
        ticket.setIsDelete(false);
        ticket.setSeatNumber(seatRepository.findBySeatNumber(ticketRequest.getSeatNumber()));
        ticket.setUserId(userRepository.findByUserId(ticketRequest.getUserId()));
        return ticket;
    }
    @Override
    public Ticket insertTicket(TicketRequest request) {
        Ticket foundTicket = ticketRepository.findById(request.getTicketId()).orElse(null);
        if(foundTicket == null){
            return ticketRepository.save(assignValueToTicket(new Ticket(),request));
        }
        throw new CustomException("500", "Ticket Already Taken");
    }

    @Override
    public Ticket updateTicket(TicketRequest request) {
        Ticket existTicket = ticketRepository.findById(request.getTicketId()).orElse(null);
        if(existTicket != null){
            Flight flight = flightRepository.findByFlightNumber(request.getFlightNumber());
            existTicket.setFlightNumber(flight);
            Seat seat = seatRepository.findBySeatNumber(request.getSeatNumber());
            existTicket.setSeatNumber(seat);
            User user = userRepository.findByUserId(request.getUserId());
            existTicket.setUserId(user);
            existTicket.setIsDelete(request.getIsDelete());
        }
        throw new CustomException("404", "Not found ticket");
    }

    @Override
    public Boolean deleteTicket(Integer ticketId) {
        try {
            ticketRepository.deleteById(ticketId);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Ticket getTicketById(Integer ticketId) {
        return ticketRepository.findById(ticketId).orElse(null);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public List<Ticket> getTicketsByUserId(Integer userId) {
        User user = userRepository.findByUserId(userId);
        return ticketRepository.findTicketByUserId(user);
    }

    @Override
    public Ticket getTicketsBySeatNumber(Integer seatNumber) {
        Seat seat = seatRepository.findBySeatNumber(seatNumber);
        return ticketRepository.findTicketBySeatNumber(seat);
    }

    @Override
    public List<Ticket> getTicketsByFlightNumber(String flightNumber) {
        Flight flight = flightRepository.findByFlightNumber(flightNumber);
        return ticketRepository.findTicketByFlightNumber(flight);
    }
}
