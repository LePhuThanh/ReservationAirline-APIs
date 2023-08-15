package com.practice.reservationAirline.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_number")
    private Integer seatNumber;
    //==> Airline
    @ManyToOne
    @JoinColumn(name = "airline_number", referencedColumnName = "airline_number")
    private Airline airLineNumber;
    //==> SeatType
    @ManyToOne
    @JoinColumn(name = "seat_type_id", referencedColumnName = "seat_type_id")
    private SeatType seatTypeId;
}
