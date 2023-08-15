package com.practice.reservationAirline.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Integer ticketId;

    private Boolean isDelete;

    //==> User
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @JsonBackReference
    private User userId;

    //==> Seat
    @ManyToOne
    @JoinColumn(name = "seat_number", referencedColumnName = "seat_number")
    private Seat seatNumber; //seat

    //==> Flight
    @ManyToOne
    @JoinColumn(name = "flight_number", referencedColumnName = "flight_number")
    @JsonBackReference
    Flight flightNumber;

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

}
