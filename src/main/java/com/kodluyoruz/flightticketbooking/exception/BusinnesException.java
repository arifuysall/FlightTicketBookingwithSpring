package com.kodluyoruz.flightticketbooking.exception;

import org.springframework.http.HttpStatus;

public class BusinnesException extends ApiException{
    public BusinnesException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
