package com.practice.reservationAirline.payloads.requests;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.practice.reservationAirline.entities.Employee;
import com.practice.reservationAirline.entities.Passenger;
import com.practice.reservationAirline.entities.Ticket;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
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
