package com.example.week3day5.advice;

import com.example.week3day5.dto.ResponseApi;
import com.example.week3day5.exception.InvalidIDException;
import com.example.week3day5.exception.NoFundsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdviceHandler {
    @ExceptionHandler(InvalidIDException.class)
    public ResponseEntity InvalidIDException(InvalidIDException e){
        String err=e.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseApi(err,400));
    }

    @ExceptionHandler(NoFundsException.class)
    public ResponseEntity NoFundsException(NoFundsException e){
        String err=e.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseApi(err,400));
    }
}
