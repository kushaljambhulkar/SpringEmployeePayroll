package com.example.employeepayroll.controller;

import com.example.employeepayroll.model.Employee;
import com.example.employeepayroll.service.EmployeePayrollAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeePayrollAppController {
//   UC 1 Create a Employee Payroll Spring Project to cater to REST Request
    @Autowired
    EmployeePayrollAppService employeePayrollAppService;
    @GetMapping("/post")
    public String post(){
        return EmployeePayrollAppService.printMesseges();
    }
//    UC2 Create a Rest Controller to demonstrate the various HTTP Methods
    @PostMapping("/insert")
    public Employee fillEmployeeDetails(@RequestBody Employee employee){
        return employeePayrollAppService.fillEmployeeDetails(employee);
    }

    @GetMapping("/get1/{id}")
    public Optional<Employee> getEmployeeInformation(@PathVariable int id){
        return employeePayrollAppService.getEmployeeDetails(id);
    }

    @GetMapping("/get")
    public List<Employee> getAllEmployeeInformation(){
        return employeePayrollAppService.getAllEmployeeDetails();
    }

    @PutMapping(value = "/update/{id}")
    public Employee editEmployeeInformation(@PathVariable int id,
                                            @RequestParam(value = "editOfRowName")int editOfRowNo,
                                            @RequestParam(value = "EnterTheValue")String EnterTheValue){
        return employeePayrollAppService.editEmployeeDetails(id,editOfRowNo,EnterTheValue);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteEmployeeInformation(@PathVariable int id){
        employeePayrollAppService.deleteEmployeeDetails(id);
    }
}
