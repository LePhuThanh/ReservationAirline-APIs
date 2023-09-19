package com.practice.reservationAirline.payloads.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationRequest {
    private String firstName;
    private String lastName;
    private String phone;
    @NonNull
    private String userName;
    @NonNull
    private String password;
    private String passport;
    private String paymentCardNumber;
    private BigDecimal salary;


}
