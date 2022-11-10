package com.example.employeepayroll.controller;

import com.example.employeepayroll.service.EmployeePayrollAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeePayrollAppController {
//   UC 1 Create a Employee Payroll Spring Project to cater to REST Request
    @Autowired
    EmployeePayrollAppService employeePayrollAppService;
    @PostMapping("/post")
    public String post(){
        return EmployeePayrollAppService.printMesseges();
    }
}
