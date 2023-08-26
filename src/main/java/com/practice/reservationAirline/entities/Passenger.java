package com.practice.reservationAirline.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passenger_id")
    private Integer passengerId;
    @Column(name = "passenger_name")
    private String passengerName;
    private String passport;
    @Column(name = "payment_card_number")
    private String paymentCardNumber;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id") // reference key
    @JsonBackReference
    private User userId;
}
