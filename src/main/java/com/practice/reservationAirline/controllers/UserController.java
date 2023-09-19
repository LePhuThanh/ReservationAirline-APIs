package com.practice.reservationAirline.controllers;

import com.practice.reservationAirline.entities.User;
import com.practice.reservationAirline.handlers.customExceptions.CustomException;
import com.practice.reservationAirline.payloads.responses.DataResponse;
import com.practice.reservationAirline.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/User")
public class UserController {
    @Autowired
    UserRepository userRepository;
    //GET
    @GetMapping(value = "/getAllUser")
    public ResponseEntity <DataResponse> getAllUser(){
        List<User> userList = userRepository.findAll();
        if(!userList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new DataResponse("200", "Get all users successfully", userList));
        }
            throw new CustomException("404", "Not found any users");
    }

    //LOGIN

}
