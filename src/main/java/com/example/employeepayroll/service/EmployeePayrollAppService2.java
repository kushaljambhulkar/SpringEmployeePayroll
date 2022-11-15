package com.example.employeepayroll.service;

import com.example.employeepayroll.dto.EmployeePayrollAppDTO;
import com.example.employeepayroll.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeePayrollAppService2 {
//    Add Details Into DataBase
    Employee addDetails(EmployeePayrollAppDTO employeePayrollAppDTO);
//    Edit Details In The DataBse
    Employee updateDetails(EmployeePayrollAppDTO employeePayrollAppDTO);
//    Update Details In the DataBase Using Setter & Getter Method
    Employee EditDetails(int id, EmployeePayrollAppDTO employeePayrollAppDTO);
//    Get Details by its id in the DataBase
    Optional<Employee> getById(int id);
    List<Employee> getAll();
}
