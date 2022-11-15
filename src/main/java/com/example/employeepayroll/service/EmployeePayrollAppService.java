package com.example.employeepayroll.service;

import com.example.employeepayroll.dto.EmployeePayrollAppDTO;
import com.example.employeepayroll.model.Employee;
import com.example.employeepayroll.repository.EmployeePayrollAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//   UC 1 Create a Employee Payroll Spring Project to cater to REST Request
@Service
public class EmployeePayrollAppService implements EmployeePayrollAppService2 {
    @Autowired
    EmployeePayrollAppRepository employeePayrollAppRepository;

    private List<Employee>employeeList = new ArrayList<Employee>();
    public static String printMesseges(){
        return "Hello, Welcome to the Employee Payroll Application";
    }
    //    Add Details Into DataBase
    @Override
    public Employee addDetails(EmployeePayrollAppDTO employeePayrollAppDTO){
        Employee EmployeeDetails = new Employee(employeeList.size() + 1,employeePayrollAppDTO);
        employeeList.add(EmployeeDetails);
        employeePayrollAppRepository.save(EmployeeDetails);
        return EmployeeDetails;
    }
    //    Edit Details In The DataBse
    @Override
    public Employee updateDetails(EmployeePayrollAppDTO employeePayrollAppDTO) {
        int id = 0;
        Optional<Employee> optional = employeePayrollAppRepository.findById(id);
        if(optional.isPresent()){
            Employee updateEmployee = new Employee(id,employeePayrollAppDTO);
            employeePayrollAppRepository.save(updateEmployee);
        }
        else {
        }
        return null;
    }

    @Override
    public Employee EditDetails(int id, EmployeePayrollAppDTO employeePayrollAppDTO) {
        Employee updateEmployee = employeePayrollAppRepository.findById(id).get();
        if(employeePayrollAppRepository.findById(id).isPresent()){
            updateEmployee.setFirstName(employeePayrollAppDTO.getFirstname());
            updateEmployee.setLastName(employeePayrollAppDTO.getLastName());
            updateEmployee.setProfilePic(employeePayrollAppDTO.getProfilePic());
            updateEmployee.setSalary(employeePayrollAppDTO.getSalary());
            updateEmployee.setNote(employeePayrollAppDTO.getNote());
            updateEmployee.setStartDate(employeePayrollAppDTO.getStartDate());
            employeePayrollAppRepository.save(updateEmployee);
            return updateEmployee;
        }else {
            return null;
        }
    }

    @Override
    public Optional<Employee> getById(int id) {
        return Optional.ofNullable(employeeList.get(id -1));
    }

    @Override
    public List<Employee> getAll() {
        return null;
    }
}
