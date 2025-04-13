package com.ms.cicd.service;

import com.ms.cicd.dto.EmployeeDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final List<EmployeeDto> employees = new ArrayList<>();

    // Create a new course
    public void addEmployee(EmployeeDto employee) {
        employees.add(employee);
    }

    // Retrieve all courses
    public List<EmployeeDto> getAllEmployees() {
        return employees;
    }

    // Retrieve a course by id
    public Optional<EmployeeDto> getEmployeeById(int id) {
        return employees.stream()
                .filter(employee -> employee.getEmployeeId() == id)
                .findFirst();
    }

    // Update a course
    public boolean updateEmployee(int id, EmployeeDto newEmployee) {
        return getEmployeeById(id).map(existingEmployee -> {
            employees.remove(existingEmployee);
            employees.add(newEmployee);
            return true;
        }).orElse(false);
    }

    // Delete a course by id
    public boolean deleteEmployee(int id) {
        return employees
                .removeIf(employee -> employee.getEmployeeId() == id);
    }
}
