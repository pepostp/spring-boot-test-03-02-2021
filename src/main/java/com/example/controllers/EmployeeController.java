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
            return employeeService.getAllEmployee();

        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
    }

    @RequestMapping(value = "/employee/insert", method=RequestMethod.POST)
    public Object insertEmployee(@RequestBody Employee employee) {
        try {
            Integer id = employeeService.insertEmployee(employee);
            return buildResponse.successResponseString("Insert employee successful id : "+ id);

        } catch (Exception e) {
            System.out.println(e);
            throw new CustomException(e.getMessage());
        }
    }

    @RequestMapping(value = "/employee/delete", method=RequestMethod.POST)
    public Object deleteEmployee(@RequestBody Employee employee){
        try {
            try{
                if (employee.getId() == null || employee.getId() == 0){
                    throw new CustomException("Empty employee id");
                }
                employeeService.deleteEmployee(employee.getId());
                return buildResponse.successResponseString("Delete employee successful id : "+ employee.getId());

            } catch (Exception e) {
                throw new CustomException("Wrong or Empty employee id");
            }

        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
    }

    @RequestMapping(value = "/employee/update", method=RequestMethod.POST)
    public Object updateEmployee(@RequestBody Employee employee) {
        try {
            try{
                if (employee.getId() == null || employee.getId() == 0){
                    throw new CustomException("Empty employee id");
                }
                if (employeeService.existsEmployee(employee.getId())){
                    Integer id = employeeService.updateEmployee(employee);
                    return buildResponse.successResponseString("Update employee successful id : "+ id);
                }else{
                    throw new CustomException("Not found employee");
                }
            } catch (Exception e) {
                throw new CustomException("Wrong or Empty employee id");
            }
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
    }

    @RequestMapping(value = "/employee/searchByID", method=RequestMethod.POST)
    public Object searchEmployeeById(@RequestBody Employee employee) {
        try {
            try{
                if (employee.getId() == null || employee.getId() == 0){
                    throw new CustomException("Empty employee id");
                }
                return employeeService.searchEmployeeById(employee.getId());

            } catch (Exception e) {
                throw new CustomException("Wrong or Empty employee id");
            }
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
    }

    @RequestMapping(value = "/employee/searchByName", method=RequestMethod.POST)
    public Object searchEmployeeByName(@RequestBody Employee employee) {
        try {
            try{
                if (employee.getName() == null || employee.getName() == ""){
                    throw new CustomException("Empty employee name");
                }
                return employeeService.searchEmployeeByName(employee.getName());

            } catch (Exception e) {
                throw new CustomException("Wrong or Empty employee name");
            }
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
    }

    @RequestMapping(value = "/employee/searchByPhone", method=RequestMethod.POST)
    public Object searchEmployeeByPhone(@RequestBody Employee employee) {
        try {
            try{
                if (employee.getPhone() == null || employee.getPhone() == ""){
                    throw new CustomException("Empty employee phone");
                }
                return employeeService.searchEmployeeByPhone(employee.getPhone());

            } catch (Exception e) {
                throw new CustomException("Wrong or Empty employee phone");
            }
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
    }

    @RequestMapping(value = "/employee/searchByEmail", method=RequestMethod.POST)
    public Object searchEmployeeByEmail(@RequestBody Employee employee) {
        try {
            try{
                if (employee.getEmail() == null || employee.getEmail() == ""){
                    throw new CustomException("Empty employee email");
                }
                return employeeService.searchEmployeeByEmail(employee.getEmail());

            } catch (Exception e) {
                throw new CustomException("Wrong or Empty employee email");
            }
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
    }


}
