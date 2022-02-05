package com.datmt.fake_api.helpers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
@Slf4j
public class ExceptionHandlingHelper {

    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<String> handleException(HttpStatus status, Exception ex) {
        return ResponseEntity.status(status)
                .body(ex.getMessage());
    }
}
