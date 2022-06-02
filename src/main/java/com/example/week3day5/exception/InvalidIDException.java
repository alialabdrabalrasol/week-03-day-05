package com.example.week3day5.exception;

public class InvalidIDException extends RuntimeException{
    public InvalidIDException(String message) {
        super(message);
    }
}
