package com.practice.reservationAirline.handlers;

import com.practice.reservationAirline.services.responses.DataResponse;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.UnsupportedEncodingException;

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
    public DataResponse handleHttpMessageConversation(HttpMessageConversionException e) {
        e.printStackTrace();
        return new DataResponse("400" , e.getMessage());
    }


    //CustomException
    @org.springframework.web.bind.annotation.ExceptionHandler(CustomException.class)
    public DataResponse handleCustomException(CustomException e) {
        e.printStackTrace();
        return new DataResponse(e.getStatus(), e.getMessage());
    }
    //UnsupportedEncodingException
    // Wrong a text include unsupported characters
    @org.springframework.web.bind.annotation.ExceptionHandler(UnsupportedEncodingException.class)
    public DataResponse handleUnsupportedEncodingException(UnsupportedEncodingException e) {
        e.printStackTrace();
        return new DataResponse("1012" , e.getMessage());
    }
    //Exception
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public DataResponse handleDefaultException(Exception e) {
        e.printStackTrace();
        return new DataResponse("500" , e.getMessage());
    }
}
