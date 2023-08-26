package com.practice.reservationAirline.services;

import com.practice.reservationAirline.entities.Passenger;
import com.practice.reservationAirline.entities.User;
import com.practice.reservationAirline.payloads.requests.PassengerRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PassengerService {
    public List<Passenger> getAllPassenger();
    public Passenger getPassengerById(Integer passengerId);
    public List<Passenger> getPassengerByPaymentCardNumber(String paymentCardNumber);
    public List<Passenger> getPassengerByPassport(String passport);
    public List<Passenger>  getPassengerByUserId(Integer userId);

    public Passenger insertNewPassenger(PassengerRequest passengerRequest);

    public Boolean deletePassengerById(Integer passengerId);

    public Passenger updatePassenger(PassengerRequest newPassenger);
    public Passenger updatePassengerByIdPassenger(PassengerRequest newPassenger);



}
