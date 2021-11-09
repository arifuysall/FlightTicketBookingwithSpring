package com.kodluyoruz.flightticketbooking.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiException extends RuntimeException{
    private HttpStatus httpStatus;

    public ApiException(String message,HttpStatus status) {
        super(message);
        httpStatus = status;
    }
}
