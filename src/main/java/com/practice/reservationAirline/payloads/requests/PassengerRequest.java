package com.practice.reservationAirline.payloads.requests;

import com.practice.reservationAirline.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerRequest {
    private Integer passengerId;
    private String passport;
    private String paymentCardNumber;
    private User userId;
}
