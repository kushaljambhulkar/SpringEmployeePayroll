package com.example.employeepayroll.controller;

import com.example.employeepayroll.dto.EmployeePayrollAppDTO;
import com.example.employeepayroll.dto.ResponseDTO;
import com.example.employeepayroll.model.Employee;
import com.example.employeepayroll.service.EmployeePayrollAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employeepayroll")
public class EmployeePayrollAppController {
//   UC 1 Create a Employee Payroll Spring Project to cater to REST Request
    @Autowired
    EmployeePayrollAppService employeePayrollAppService;
    @PostMapping("/post")
    public String post(){
        return EmployeePayrollAppService.printMesseges();
    }
//    UC2 Create a Rest Controller to demonstrate the various HTTP Methods
    @PostMapping("/insert")
    public ResponseEntity<ResponseDTO> addDetails(@Valid @RequestBody EmployeePayrollAppDTO employeePayrollAppDTO){
        Employee employee = employeePayrollAppService.addDetails(employeePayrollAppDTO);
        ResponseDTO responseDTO = new ResponseDTO("Your Data Added Successfully!!!",employee);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    //    Adding Details Into DataBase
    @PutMapping("/update/{Id}")
    public ResponseEntity<ResponseDTO> updateDetails(@PathVariable int Id,@RequestBody EmployeePayrollAppDTO employeePayrollAppDTO){
        Employee updateEmployee = employeePayrollAppService.updateDetails(employeePayrollAppDTO);
        ResponseDTO responseDTO = new ResponseDTO("Employee Data Updated Successfully",updateEmployee);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
    //    Edit Details In The DataBse
    @PutMapping("/edit/{Id}")
    public ResponseEntity<ResponseDTO> editDetails(@PathVariable int Id,@RequestBody EmployeePayrollAppDTO employeePayrollAppDTO){
        Employee updateEmployee = employeePayrollAppService.EditDetails(Id,employeePayrollAppDTO);
        ResponseDTO responseDTO = new ResponseDTO("Employee Data Updated Successfully",updateEmployee);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }
    // Method to get data by its Id here we use Optional in return because if Id present
    // then it return data otherwise return null
    @GetMapping("/getId/{Id}")
    public ResponseEntity<ResponseDTO> getById(@PathVariable(value = "Id") int Id) {
        Optional<Employee> updateEmployee = employeePayrollAppService.getById(Id);
        ResponseDTO responseDTO = new ResponseDTO("Get call Id successfully", updateEmployee);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    //Get Details by its id in the DataBase
    @GetMapping("/getall")
    public List<Employee> getAll() {
        return employeePayrollAppService.getAll();
    }

    //For Delete data by its Id
    @DeleteMapping("delete/{Id}")
    public List<Employee> deleteBYId(@PathVariable(value = "Id") int Id) {
        return employeePayrollAppService.deleteById(Id);
    }

    //For Delete all data
    @DeleteMapping("/delete-all")
    public List<Employee> deleteAll() {
        return employeePayrollAppService.deleteAll();
    }

    //Count Total employees in database using id
    @GetMapping("/countInRepo")
    public String countById() {
        return employeePayrollAppService.countByIdInRepository();
    }

    //Count Total employees in saved arraylist
    @GetMapping("/countInList")
    public String countIdInSavedList() {
        return employeePayrollAppService.countIdInSavedList();
    }

}
