package com.practice.reservationAirline.handlers.customExceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomException extends  RuntimeException{
    private String status;

    public CustomException(String message, String status) {
        super(message);
        this.status = status;
    }
}
