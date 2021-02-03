package com.example.repositories;

import com.example.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByName(@Param("Name") String name);
    List<Employee> findByPhone(@Param("phone") String phone);
    List<Employee> findByEmail(@Param("email") String email);

}
