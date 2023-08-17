package com.practice.reservationAirline.repositories;

import com.practice.reservationAirline.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface PassengerRepositories extends JpaRepository<Passenger, Integer> {

}
