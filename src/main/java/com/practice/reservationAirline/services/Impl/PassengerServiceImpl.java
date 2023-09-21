package com.practice.reservationAirline.services.Impl;

import com.practice.reservationAirline.entities.Passenger;
import com.practice.reservationAirline.entities.User;
import com.practice.reservationAirline.handlers.customExceptions.CustomException;
import com.practice.reservationAirline.payloads.requests.PassengerRequest;
import com.practice.reservationAirline.repositories.PassengerRepository;
import com.practice.reservationAirline.repositories.UserRepository;
import com.practice.reservationAirline.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("PassengerServiceImpl")
public class PassengerServiceImpl implements PassengerService {
    @Autowired
    private PassengerRepository passengerRepository;
    @Autowired
    private UserRepository userRepository;
    //method assign value to passenger
    public Passenger assignValueToPassenger(Passenger passenger, PassengerRequest passengerRequest){
        passenger.setPassengerId(passengerRequest.getPassengerId());
        passenger.setPassengerName(passengerRequest.getPassengerName());
        passenger.setPassport(passengerRequest.getPassport());
        passenger.setPaymentCardNumber(passengerRequest.getPaymentCardNumber());
        passenger.setUserId(userRepository.findByUserId(passengerRequest.getPassengerId()));
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
    @Override
    public List<Passenger> getPassengerByUserId(Integer userId){
        User userByUserId = userRepository.findByUserId(userId);
        return passengerRepository.findByUserId(userByUserId);
    }

    @Override
    public List<Passenger> getAllPassenger(){
        return passengerRepository.findAll();
    }

    //POST
    @Override
    public Passenger insertNewPassenger(PassengerRequest passengerRequest){
        Passenger foundPassenger = passengerRepository.findById(passengerRequest.getPassengerId()).orElse(null);
        if(foundPassenger == null) {
            return passengerRepository.save(assignValueToPassenger(new Passenger(), passengerRequest));
        }
            throw new CustomException("500", "Passenger Id Already Taken");
    }
    //

    //DELETE
    @Override
    public Boolean deletePassengerById(Integer passengerId){
        try {
            passengerRepository.deleteById(passengerId);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    //UPDATE
    @Override
    public Passenger updatePassenger(PassengerRequest newPassenger){
        Passenger existPassenger = passengerRepository.findById(newPassenger.getPassengerId()).orElse(null);
        if(existPassenger != null) {
            User user = userRepository.findByUserId(newPassenger.getUserId());
            existPassenger.setPassengerName(newPassenger.getPassengerName());
            existPassenger.setPassport(newPassenger.getPassport());
            existPassenger.setPaymentCardNumber(newPassenger.getPaymentCardNumber());
            existPassenger.setUserId(user);
            return passengerRepository.save(existPassenger);
        }
        throw new CustomException("404", "Not found passenger");
    }
    @Override
    public Passenger updatePassengerByIdPassenger(PassengerRequest newPassenger){
        return null;
    }
}
