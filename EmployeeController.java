//package com.ms.cicd.controller;

// import com.ms.cicd.dto.EmployeeDto;
// import com.ms.cicd.service.EmployeeService;
import EmployeeDto;
import EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService EmployeeService;


    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<EmployeeDto> addNewEmployee(@RequestBody EmployeeDto employee) {
        EmployeeService.addEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<EmployeeDto>> getAllTheEmployees() {
        List<EmployeeDto> employees = EmployeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<EmployeeDto> getEmpById(@PathVariable int id) {
        Optional<EmployeeDto> emp = EmployeeService.getEmployeeById(id);
        return emp.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<EmployeeDto> updateTheEmployee(@PathVariable int id, @RequestBody EmployeeDto newEmp) {
        boolean updated = EmployeeService.updateEmployee(id, newEmp);
        if (updated) {
            return new ResponseEntity<>(newEmp, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<String> deleteTheEmployee(@PathVariable int id) {
        boolean deleted = EmployeeService.deleteEmployee(id);
        if (deleted) {
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>("Employee Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "UP";
    }


    @GetMapping("/welcome")
    public String greetings() {
        return "Hello Java Demo , Good Job !";
    }


}
