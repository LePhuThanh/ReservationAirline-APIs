package com.practice.reservationAirline.repositories;

import com.practice.reservationAirline.entities.Flight;
import com.practice.reservationAirline.entities.Seat;
import com.practice.reservationAirline.entities.Ticket;
import com.practice.reservationAirline.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    List<Ticket> findTicketByUserId(User userId);
    List<Ticket> findTicketByFlightNumber(Flight flightNumber);
    Ticket findTicketBySeatNumber(Seat seatNumber);

}
