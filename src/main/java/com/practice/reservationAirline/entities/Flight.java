package com.practice.reservationAirline.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "flight_number")
    private String flightNumber;
    private String destination;
    private String departure;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = "GMT+7") // shape : output is String , format is yyyy-MM--dd
    @Column(name = "departure_date")
    @Temporal(TemporalType.DATE) // Determine attribute DATE
    private Date departureDate;

    @JsonFormat(pattern = "HH:mm", shape = JsonFormat.Shape.STRING, timezone = "GMT+7")
    @Column(name = "departure_time")
    @Temporal(TemporalType.TIME)
    private Date departureTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", shape = JsonFormat.Shape.STRING, timezone = "GMT+7")
    @Column(name = "arrival_date")
    @Temporal(TemporalType.TIMESTAMP) // DATE & Hour
    private Date arrivalDate;

    @ManyToOne
    Airline airlineNumber;

    @Column(name = "is_cancel")
    private Boolean isCancel;

    //==> Ticker
    @OneToMany(mappedBy = "flightNumber", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Ticket> airline_airline_number; //seats
    public Boolean getCancel() {
        return isCancel;
    }

    public void setCancel(Boolean cancel) {
        isCancel = cancel;
    }

}
