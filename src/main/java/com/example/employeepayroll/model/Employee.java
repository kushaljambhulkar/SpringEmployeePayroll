package com.example.employeepayroll.model;

import com.example.employeepayroll.dto.EmployeePayrollAppDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue
    private int Id;
    private String firstName;
    private String lastName;
    private String profilePic;
    private String note;
    private long salary;
    LocalDate startDate;

//    Insert Constructor
    public Employee(EmployeePayrollAppDTO employeePayrollAppDTO){
        this.firstName = employeePayrollAppDTO.getLastName();
        this.lastName = employeePayrollAppDTO.getLastName();
        this.profilePic = employeePayrollAppDTO.getProfilePic();
        this.note = employeePayrollAppDTO.getNote();
        this.salary = employeePayrollAppDTO.getSalary();
        this.startDate = employeePayrollAppDTO.getStartDate();
    }
//    Update Constructor
    public Employee(int id,EmployeePayrollAppDTO employeePayrollAppDTO){
        this.Id = id;
        this.firstName = employeePayrollAppDTO.getLastName();
        this.lastName = employeePayrollAppDTO.getLastName();
        this.profilePic = employeePayrollAppDTO.getProfilePic();
        this.note = employeePayrollAppDTO.getNote();
        this.salary = employeePayrollAppDTO.getSalary();
        this.startDate = employeePayrollAppDTO.getStartDate();
    }

}
