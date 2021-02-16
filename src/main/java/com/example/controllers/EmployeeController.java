package com.example.controllers;

import com.example.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.services.EmployeeService;

import java.util.List;

@RestController
public class  EmployeeController{

    @Autowired
    EmployeeService employeeService;

    BuildResponse buildResponse = new BuildResponse();

    @RequestMapping(value = "/employee/all", method=RequestMethod.GET)
    public List<Employee> allEmployee() {
        try {
            if (0 == employeeService.getAllEmployee().size()){
                throw new CustomException("Not found employee", 404);
            }
            return employeeService.getAllEmployee();

        } catch (Exception e) {
            throw new CustomException(e.getMessage(), 500);
        }
    }

    @RequestMapping(value = "/employee/insert", method=RequestMethod.POST)
    public Object insertEmployee(@RequestBody Employee employee) {
        try {
            Integer id = employeeService.insertEmployee(employee);
            return  buildResponse.successResponseBuilder("Insert employee successful id : "+ id, 201);
        } catch (Exception e) {
            throw new CustomException(e.getMessage(), 500);
        }
    }

    @RequestMapping(value = "/employee/delete", method=RequestMethod.POST)
    public Object deleteEmployee(@RequestBody Employee employee){
        try {
                if (employee.getId() == null || employee.getId() == 0){
                    throw new CustomException("Empty employee id", 404);
                }
                employeeService.deleteEmployee(employee.getId());
            return  buildResponse.successResponseBuilder("Delete employee successful id : "+ employee.getId(), 200);

        } catch (Exception e) {
            throw new CustomException(e.getMessage(), 500);
        }
    }

    @RequestMapping(value = "/employee/update", method=RequestMethod.POST)
    public Object updateEmployee(@RequestBody Employee employee) {
        try {
            if (employee.getId() == null || employee.getId() == 0){
                throw new CustomException("Empty employee id", 404);
            }
            if (employeeService.existsEmployee(employee.getId())){
                Integer id = employeeService.updateEmployee(employee);
                return  buildResponse.successResponseBuilder("Update employee successful id : "+ id, 200);
            }else{
                throw new CustomException("Not found employee", 404);
            }

        } catch (Exception e) {
            throw new CustomException(e.getMessage(), 500);
        }
    }

    @RequestMapping(value = "/employee/searchByID", method=RequestMethod.POST)
    public Object searchEmployeeById(@RequestBody Employee employee) {
        try {
            if (employee.getId() == null || employee.getId() == 0){
                throw new CustomException("Empty employee id", 404);
            }

            return employeeService.searchEmployeeById(employee.getId());

        } catch (Exception e) {
            throw new CustomException(e.getMessage(), 500);
        }
    }

    @RequestMapping(value = "/employee/searchByName", method=RequestMethod.POST)
    public Object searchEmployeeByName(@RequestBody Employee employee) {
        try {
            if (employee.getName() == null || employee.getName() == ""){
                throw new CustomException("Empty employee name", 404);
            }
            if (0 == employeeService.searchEmployeeByName(employee.getName()).size()){
                throw new CustomException("Not found employee", 404);
            }
            return employeeService.searchEmployeeByName(employee.getName());
        } catch (Exception e) {
            throw new CustomException(e.getMessage(), 500);
        }
    }

    @RequestMapping(value = "/employee/searchByPhone", method=RequestMethod.POST)
    public Object searchEmployeeByPhone(@RequestBody Employee employee) {
        try {
            if (employee.getPhone() == null || employee.getPhone() == ""){
                throw new CustomException("Empty employee phone", 404);
            }
            if (0 == employeeService.searchEmployeeByPhone(employee.getPhone()).size()){
                throw new CustomException("Not found employee", 404);
            }
            return employeeService.searchEmployeeByPhone(employee.getPhone());
        } catch (Exception e) {
            throw new CustomException(e.getMessage(), 500);
        }
    }

    @RequestMapping(value = "/employee/searchByEmail", method=RequestMethod.POST)
    public Object searchEmployeeByEmail(@RequestBody Employee employee) {
        try {
            if (employee.getEmail() == null || employee.getEmail() == ""){
                throw new CustomException("Empty employee email", 404);
            }
            if (0 == employeeService.searchEmployeeByEmail(employee.getEmail()).size()){
                throw new CustomException("Not found employee", 404);
            }
            return employeeService.searchEmployeeByEmail(employee.getEmail());
        } catch (Exception e) {
            throw new CustomException(e.getMessage(), 500);
        }
    }


}
