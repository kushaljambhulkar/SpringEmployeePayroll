package com.example.employeepayroll.dto;

public class ResponseDTO {
    private String message;
    private Object Employee;

    public ResponseDTO(String message, Object employee) {
        this.message = message;
        this.Employee = employee;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getEmployee() {
        return Employee;
    }

    public void setEmployee(Object employee) {
        Employee = employee;
    }
}
