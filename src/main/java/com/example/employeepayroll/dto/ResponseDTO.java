package com.example.employeepayroll.dto;


import lombok.Data;

@Data
public class ResponseDTO {
    private String message;
    private Object Employee;

    public ResponseDTO(String message, Object employee) {
        this.message = message;
        this.Employee = employee;
    }

}
