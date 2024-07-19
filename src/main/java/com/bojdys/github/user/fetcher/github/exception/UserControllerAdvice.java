package com.bojdys.github.user.fetcher.github.exception;

import com.bojdys.github.user.fetcher.github.dto.ExceptionDtoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserControllerAdvice {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionDtoResponse> handleUserNotFoundException(UserNotFoundException e){
        ExceptionDtoResponse response = new ExceptionDtoResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
