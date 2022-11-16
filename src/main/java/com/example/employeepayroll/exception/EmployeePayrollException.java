package com.example.employeepayroll.exception;

public class EmployeePayrollException extends RuntimeException{
    public EmployeePayrollException(String message) {
        //super keyword used to give message to the runtime exception class
        super(message);
    }
}
