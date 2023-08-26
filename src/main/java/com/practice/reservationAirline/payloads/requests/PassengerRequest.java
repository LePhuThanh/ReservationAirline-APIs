package com.practice.reservationAirline.payloads.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerRequest {
    private Integer passengerId;
    private String passengerName;
    private String passport;
    private String paymentCardNumber;
    private int userId;
}
