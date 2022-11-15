package com.example.employeepayroll.dto;

import java.time.LocalDate;

public class EmployeePayrollAppDTO {
    public String firstName;
    public String lastName;
    private String profilePic;
    private String note;
    private long salary;
    LocalDate startDate;

    public EmployeePayrollAppDTO(String firstName,String lastName, String profilePic,
                                 String note, long salary, LocalDate startDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.profilePic = profilePic;
        this.note = note;
        this.salary = salary;
        this.startDate = startDate;
    }

    public String getFirstname() {
        return firstName;
    }

    public void setFirstname(String firstname) {
        this.firstName= firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    @Override
    public String toString() {
        return "EmployeePayrollAppDTO{"+
                ", firstName='" + firstName+ '\'' +
                ", lastName='" + lastName + '\'' +
                ", profilePic='" + profilePic + '\'' +
                ", note='" + note + '\'' +
                ", salary=" + salary +
                ", startDate=" + startDate +
                '}';
        }
    }
