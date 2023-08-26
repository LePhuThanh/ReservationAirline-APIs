package com.practice.reservationAirline.services.Impl;

import com.practice.reservationAirline.entities.User;
import com.practice.reservationAirline.payloads.requests.RegisterRequest;
import com.practice.reservationAirline.repositories.UserRepository;
import com.practice.reservationAirline.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    @Override
    public User getUserByUserName(String userName){
        return userRepository.findUserByUserName(userName);
    }
//    @Override
//    public User registerAsPassenger(RegisterRequest registerRequest){
//        return
//    }
//    @Override
//    public User addNewEmployee(RegisterRequest registerRequest){
//        return
//    }
}
