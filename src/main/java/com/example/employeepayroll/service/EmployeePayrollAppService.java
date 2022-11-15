package com.example.employeepayroll.service;

import com.example.employeepayroll.dto.EmployeePayrollAppDTO;
import com.example.employeepayroll.model.Employee;
import com.example.employeepayroll.repository.EmployeePayrollAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//   UC 1 Create a Employee Payroll Spring Project to cater to REST Request
@Service
public class EmployeePayrollAppService implements EmployeePayrollAppService2 {
    @Autowired
    EmployeePayrollAppRepository employeePayrollAppRepository;
    //Array List to get data by id
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
            employeeList.set(id -1,updateEmployee);
            employeePayrollAppRepository.save(updateEmployee);
            return updateEmployee;
        }
        else {
        }
        return null;
    }

    //    Update Details In the DataBase Using Setter & Getter Method
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

    //    Get Details by its id in the DataBase
    @Override
    public List<Employee> getAll() {
        return null;
    }

    @Override
    //Delete data by its id
    public List<Employee> deleteById(int id) {
        employeePayrollAppRepository.deleteById(id);
        employeeList.remove(id - 1);
        return employeePayrollAppRepository.findAll();
    }

    @Override
    //Delete all the data in database
    public List<Employee> deleteAll() {
        employeeList.clear();
        employeePayrollAppRepository.deleteAll();
        return employeePayrollAppRepository.findAll();
    }

    @Override
    //Count Total employees in database using id
    public String countByIdInRepository() {
        return "Total employees in database are :- " + employeePayrollAppRepository.count();
    }

    @Override
    //Count Total employees in database using id
    public String countIdInSavedList() {
        return "Number of employees in the List is : " + employeeList.size();
    }
}
