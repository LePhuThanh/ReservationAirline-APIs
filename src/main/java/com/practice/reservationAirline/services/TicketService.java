package com.practice.reservationAirline.services;

import com.practice.reservationAirline.entities.Ticket;
import com.practice.reservationAirline.payloads.requests.TicketRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TicketService {
    public Ticket insertTicket(TicketRequest request);
    public Ticket updateTicket(TicketRequest request);
    public Boolean deleteTicket(Integer ticketId);
    public Ticket getTicketById(Integer ticketId);
    public List<Ticket> getAllTickets();
    public List<Ticket> getTicketsByUserId(Integer userId);
    public Ticket getTicketsBySeatNumber(Integer seatNumber);
    public List<Ticket> getTicketsByFlightNumber(String flightNumber);

}
