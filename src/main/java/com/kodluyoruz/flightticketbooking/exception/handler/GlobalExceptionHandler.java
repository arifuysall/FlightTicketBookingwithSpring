package com.kodluyoruz.flightticketbooking.exception.handler;

import com.kodluyoruz.flightticketbooking.exception.ApiException;
import com.kodluyoruz.flightticketbooking.exception.NotFoundException;
import com.kodluyoruz.flightticketbooking.model.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(ApiException exception) {
        log.error("Exception is occurred. Exception:{}", exception.getMessage());
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(exception.getMessage())
                .exceptionType(exception.getClass().getSimpleName())
                .build();
        return ResponseEntity.status(exception.getHttpStatus()).body(errorResponse);
    }
}
