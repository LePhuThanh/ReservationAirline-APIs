package com.practice.reservationAirline.payloads.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketRequest {
    private Integer ticketId;
    private String flightNumber;
    private Integer seatNumber;
    private Integer userId;
    private Boolean isDelete;
}
