package com.practice.reservationAirline.services;

import com.practice.reservationAirline.entities.User;
import com.practice.reservationAirline.payloads.requests.RegisterRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getAllUser();
    User getUserByUserName(String userName);
//    User registerAsPassenger(RegisterRequest registerRequest);
//    User addNewEmployee(RegisterRequest registerRequest);

}
