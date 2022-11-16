package com.example.employeepayroll.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePayrollAppDTO {

    @NotEmpty(message = "Employee First name is mandatory")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "Employee First Name Invalid")
    public String firstName;


    @NotNull(message = "Employee Last name is mandatory")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "Employee Last Name Invalid")
    public String lastName;


    @NotBlank
    public String profilePic;

    @NotEmpty(message = "Notes is mandatory")
    private String note;


//    @FutureOrPresent


    @NotNull
    @Min(value = 5000000, message = "Minimum wage should be more than 50 lac")
    private Long salary;

//    @NotEmpty(message = "Start Date is mandatory")
    private LocalDate startDate;

}
