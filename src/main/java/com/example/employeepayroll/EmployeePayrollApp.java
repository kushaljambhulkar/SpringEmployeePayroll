package com.example.employeepayroll;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//slf4j for logging in console
@Slf4j
public class EmployeePayrollApp {

    public static void main(String[] args)
    {
        ConfigurableApplicationContext context = SpringApplication.run(EmployeePayrollApp.class, args);
        log.info("Employee Payroll Application Starded in {} Environment" + context.getEnvironment().getProperty("environment"));
        log.info("Employee payroll DB User is {} " + context.getEnvironment().getProperty("spring.datasource.username"));
    }

}
