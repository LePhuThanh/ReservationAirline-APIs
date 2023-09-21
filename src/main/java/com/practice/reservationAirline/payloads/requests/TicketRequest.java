package com.practice.reservationAirline.payloads.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketRequest {
    private int ticketId;
    private String flightNumber;
    private int seatNumber;
    private int userId;
    private Boolean isDelete;
}
