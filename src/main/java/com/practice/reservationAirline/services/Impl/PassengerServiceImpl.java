package com.practice.reservationAirline.services.Impl;

import com.practice.reservationAirline.entities.Passenger;
import com.practice.reservationAirline.payloads.requests.PassengerRequest;
import com.practice.reservationAirline.repositories.PassengerRepository;
import com.practice.reservationAirline.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {
    @Autowired
    private PassengerRepository passengerRepository;
    //method assign value to passenger
    public Passenger assignValueToPassenger(Passenger passenger, PassengerRequest passengerRequest){
        passenger.setPassengerId(passengerRequest.getPassengerId());
        passenger.setPassport(passengerRequest.getPassport());
        passenger.setPaymentCardNumber(passengerRequest.getPaymentCardNumber());
        passenger.setUserId(passengerRequest.getUserId());
        return passenger;
    }


    @Override
    public List<Passenger> getAllPassenger(){
        return passengerRepository.findAll();
    }
    //Don't use
    @Override
    public Passenger insertNewPassenger(PassengerRequest passengerRequest){
        Passenger passenger = new Passenger();
        passenger = assignValueToPassenger(passenger, passengerRequest);
        return passengerRepository.save(passenger);
    }
}
