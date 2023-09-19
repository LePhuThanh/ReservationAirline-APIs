package com.practice.reservationAirline.payloads.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightRequest {
    private String flightNumber;
    private String destination;
    private String departure;
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = "GMT+7")
    private Date departureDate;
    @JsonFormat(pattern = "HH:mm", shape = JsonFormat.Shape.STRING, timezone = "GMT+7")
    private Date departureTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", shape = JsonFormat.Shape.STRING, timezone = "GMT+7")
    private Date arrivalDate;
    private Integer airlineNumber;

}
