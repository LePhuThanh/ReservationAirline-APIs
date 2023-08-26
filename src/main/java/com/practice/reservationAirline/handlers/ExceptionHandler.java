package com.practice.reservationAirline.handlers;

import com.practice.reservationAirline.handlers.customExceptions.CustomException;
import com.practice.reservationAirline.payloads.responses.DataResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.UnsupportedEncodingException;


//Create @ExceptionHandler to handle Exception in class Controller
@RestControllerAdvice // Global exception handlers
public class ExceptionHandler {
    //RuntimeException
    //General Application, unexpected situation
    @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public DataResponse handleRuntimeException(RuntimeException e) {
        e.printStackTrace(); // Track to exception
        return new DataResponse("400", e.getMessage());
    }
    //HttpMessageConversionException
    //Wrong format HTTP data, wrong enter data
    @org.springframework.web.bind.annotation.ExceptionHandler(HttpMessageConversionException.class)
    @ResponseBody
    public DataResponse handleHttpMessageConversation(HttpMessageConversionException e) {
        e.printStackTrace();
        return new DataResponse("400" , e.getMessage());
    }
    //UnsupportedEncodingException
    // Wrong a text include unsupported characters
    @org.springframework.web.bind.annotation.ExceptionHandler(UnsupportedEncodingException.class)
    @ResponseBody
    public DataResponse handleUnsupportedEncodingException(UnsupportedEncodingException e) {
        e.printStackTrace();
        return new DataResponse("1012" , e.getMessage());
    }
    //Exception
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseBody
    public DataResponse handleDefaultException(Exception e) {
        e.printStackTrace();
        return new DataResponse("500" , e.getMessage());
    }


    //CustomException
    @org.springframework.web.bind.annotation.ExceptionHandler(CustomException.class)
    @ResponseBody
    public DataResponse handleCustomException(CustomException e) {
        e.printStackTrace();
        return new DataResponse(e.getStatus(), e.getMessage());
    }


}
