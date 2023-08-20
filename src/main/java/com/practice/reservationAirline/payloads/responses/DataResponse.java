package com.practice.reservationAirline.payloads.responses;

import lombok.Data;

@Data
public class DataResponse {
    private String status;
    private String message;
    private Object data;
    public DataResponse (String status, String message) {
        this.status = status;
        this.message = message;
        this.data = null;
    }
    public DataResponse (String status, Object data, String message) {
        this.status = status;
//        this.message = null;
        this.message = message;
        this.data = data;

    }

}
