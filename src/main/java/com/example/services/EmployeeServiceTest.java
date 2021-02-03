package com.example.services;

import com.example.models.Employee;
import com.example.repositories.EmployeeRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository mockEmployeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // insert test
    @Test
    public void insertEmployeeTest(){

        Employee mock_employee = new Employee();
        doReturn(Employee.class).when(mockEmployeeRepository).save(mock_employee);
    }

    //update test (save with id = update)
    @Test
    public void updateEmployeeTest(){
        Employee mock_employee = new Employee();
        doReturn(Employee.class).when(mockEmployeeRepository).save(mock_employee);
    }

    //delete test
    @Test
    public void deleteEmployeeTest(){
        Employee mock_employee = new Employee();
        doNothing().when(mockEmployeeRepository).deleteById(mock_employee.getId());
    }

    //search by id test
    @Test
    public void searchEmployeeByIdTest(){
        Employee mock_employee = new Employee();
        doReturn(Optional.of(mock_employee)).when(mockEmployeeRepository).findById(mock_employee.getId());
    }

    //search by name test
    @Test
    public void searchEmployeeByNameTest(){
        Employee mock_employee = new Employee();
        List<?> someList = new ArrayList<>();
        doReturn(someList).when(mockEmployeeRepository).findByName(mock_employee.getName());
    }

    //search by phone test
    @Test
    public void searchEmployeeByPhoneTest(){
        Employee mock_employee = new Employee();
        List<?> someList = new ArrayList<>();
        doReturn(someList).when(mockEmployeeRepository).findByPhone(mock_employee.getPhone());
    }

    //search by email test
    @Test
    public void searchEmployeeByEmailTest(){
        Employee mock_employee = new Employee();
        List<?> someList = new ArrayList<>();
        doReturn(someList).when(mockEmployeeRepository).findByEmail(mock_employee.getEmail());
    }

}
