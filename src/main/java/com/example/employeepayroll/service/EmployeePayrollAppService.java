package com.example.employeepayroll.service;

import com.example.employeepayroll.model.Employee;
import com.example.employeepayroll.repository.EmployeePayrollAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//   UC 1 Create a Employee Payroll Spring Project to cater to REST Request
@Service
public class EmployeePayrollAppService {
    @Autowired
    EmployeePayrollAppRepository employeePayrollAppRepository;
    public static String printMesseges(){
        return "Hello, Welcome to the Employee Payroll Application";
    }

    public Employee fillEmployeeDetails(Employee employee){
        return employeePayrollAppRepository.save(employee);
    }

    public List<Employee> getAllEmployeeDetails() {
        return employeePayrollAppRepository.findAll();
    }

    public Employee editEmployeeDetails(int id, int editOfRowNo,String enterTheValue) {
        Optional<Employee> employee = employeePayrollAppRepository.findById(id);
        if (employee.get().getId() == id){
            switch (editOfRowNo){
                case 1:
                    int id1 = Integer.parseInt(enterTheValue);
                    employee.get().setId(id1);
                    break;
                case 2:
                    employee.get().setFirstName(enterTheValue);
                    break;
                case 3:
                    employee.get().setLastName(enterTheValue);
                    break;
                case 4:
                    employee.get().setProfilePic(enterTheValue);
                    break;
                case 5:
                    employee.get().setNote(enterTheValue);
                    break;
                case 6:
                    long salary = Long.parseLong(enterTheValue);
                    employee.get().setSalary(salary);
                    break;
                case 7:
                    employee.get().setStartDate(enterTheValue);
                    break;
            }
        }
        return employeePayrollAppRepository.save(employee.get());
    }

    public void deleteEmployeeDetails(int id) {
        Optional <Employee> employee = employeePayrollAppRepository.findById(id);
        employeePayrollAppRepository.delete(employee.get());
    }

    public Optional<Employee> getEmployeeDetails(int id) {
        return employeePayrollAppRepository.findById(id);
    }
}
