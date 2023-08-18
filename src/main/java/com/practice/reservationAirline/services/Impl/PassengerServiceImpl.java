package com.practice.reservationAirline.services.Impl;

import com.practice.reservationAirline.entities.Passenger;
import com.practice.reservationAirline.entities.User;
import com.practice.reservationAirline.payloads.requests.PassengerRequest;
import com.practice.reservationAirline.repositories.PassengerRepository;
//import com.practice.reservationAirline.repositories.UserRepository;
import com.practice.reservationAirline.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PassengerServiceImpl")
public class PassengerServiceImpl implements PassengerService {
    @Autowired
    private PassengerRepository passengerRepository;
//    @Autowired
//    private UserRepository userRepository;
    //method assign value to passenger
    public Passenger assignValueToPassenger(Passenger passenger, PassengerRequest passengerRequest){
        passenger.setPassengerId(passengerRequest.getPassengerId());
        passenger.setPassport(passengerRequest.getPassport());
        passenger.setPaymentCardNumber(passengerRequest.getPaymentCardNumber());
        passenger.setUserId(passengerRequest.getUserId());
        return passenger;
    }
    //GET
    @Override
    public Passenger getPassengerById(Integer passengerId){
        return passengerRepository.findById(passengerId).orElse(null);
    }
    @Override
    public List<Passenger> getPassengerByPaymentCardNumber(String paymentCardNumber){
        return passengerRepository.findByPaymentCardNumber(paymentCardNumber);
    }
    @Override
    public List<Passenger> getPassengerByPassport(String passport){
        return passengerRepository.findByPassport(passport);
    }
//    @Override
//    public List<Passenger> getPassengerByUserId(Integer userId){
//        User userByUserId = userRepository.findByUserId(userId);
//        return passengerRepository.findByUserId(userByUserId);
//    }

    @Override
    public List<Passenger> getAllPassenger(){
        return passengerRepository.findAll();
    }

    //POST
    @Override
    public Passenger insertNewPassenger(PassengerRequest passengerRequest){
        Passenger passenger = new Passenger();
        passenger = assignValueToPassenger(passenger, passengerRequest);
        return passengerRepository.save(passenger);
    }
    //DELETE
    //
}
