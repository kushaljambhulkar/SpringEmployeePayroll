package com.example.employeepayroll.model;

import com.example.employeepayroll.dto.EmployeePayrollAppDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private int Id;
    public String firstName;
    private String lastName;
    private String profilePic;
    private String note;
    private long salary;
    LocalDate startDate;

    public Employee(int id, String firstName, String lastName, String profilePic, String note, long salary, LocalDate startDate) {
        this.Id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profilePic = profilePic;
        this.note = note;
        this.salary = salary;
        this.startDate = startDate;
    }


    public Employee() {

    }
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

    public void setId(int id) {
        this.Id = id;
    }

    public int getId() {
        return Id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public long getSalary() {
        return salary;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}
