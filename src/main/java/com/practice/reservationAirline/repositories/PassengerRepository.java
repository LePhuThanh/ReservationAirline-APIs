package com.practice.reservationAirline.repositories;

import com.practice.reservationAirline.entities.Passenger;
import com.practice.reservationAirline.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;


@EnableJpaRepositories
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
    List<Passenger> findByPaymentCardNumber(String paymentCardNumber);
    List<Passenger> findByPassport(String passport);
    List<Passenger> findByUserId(User userId);
    List<Passenger> findByPassengerName(String passengerName);

}
