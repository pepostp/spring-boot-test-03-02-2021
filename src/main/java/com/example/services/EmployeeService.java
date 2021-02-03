package com.example.services;

import com.example.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeService() {
    }


    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public Integer insertEmployee(Employee employee){
        Employee result = employeeRepository.save(employee);
        System.out.println(result);
        return result.getId();
    }

    public void deleteEmployee(Integer id){
        employeeRepository.deleteById(id);
    }

    public Integer updateEmployee(Employee employee){
        Employee result = employeeRepository.save(employee);
        return result.getId();
    }

    public boolean existsEmployee(Integer id){
        return employeeRepository.existsById(id);
    }

    public Optional<Employee> searchEmployeeById(Integer id){
        return employeeRepository.findById(id);
    }

    public List<Employee> searchEmployeeByName(String name){
        return employeeRepository.findByName(name);
    }

    public List<Employee> searchEmployeeByPhone(String phone){
        return employeeRepository.findByPhone(phone);
    }

    public List<Employee> searchEmployeeByEmail(String email){
        return employeeRepository.findByEmail(email);
    }
}
