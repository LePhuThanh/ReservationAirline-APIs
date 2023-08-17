package com.practice.reservationAirline.services.Impl;

import com.practice.reservationAirline.entities.Passenger;
import com.practice.reservationAirline.payloads.requests.PassengerRequest;

import java.util.List;

public interface PassengerService {
    public List<Passenger> getAllPassenger();
    public Passenger addPassenger(PassengerRequest passengerRequest);

}
