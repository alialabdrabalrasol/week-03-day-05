package com.example.week3day5.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor @Data
public class ResponseApi {
    private String message;
    private Integer status;
}
