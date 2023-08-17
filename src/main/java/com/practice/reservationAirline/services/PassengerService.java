package com.practice.reservationAirline.services;

import com.practice.reservationAirline.entities.Passenger;
import com.practice.reservationAirline.payloads.requests.PassengerRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PassengerService {
    public List<Passenger> getAllPassenger();
    public Passenger insertNewPassenger(PassengerRequest passengerRequest);

}
