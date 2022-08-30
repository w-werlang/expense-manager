package com.wwerlang.learnspringhibernate.controller;

import com.google.gson.Gson;
import com.wwerlang.learnspringhibernate.domain.Employee;
import com.wwerlang.learnspringhibernate.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> find(@PathVariable int id) {
        Employee employee = employeeService.find(id);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> list() {
        List<Employee> employees = employeeService.list();
        return ResponseEntity.ok(employees);
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> save(@RequestBody String employeeJSON) {
        Employee employee = parseEmployee(employeeJSON);
        employee = employeeService.save(employee);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/employee")
    public void delete(@RequestBody String employeeJSON) {
        Employee employee = parseEmployee(employeeJSON);
        employeeService.delete(employee);
    }

    private Employee parseEmployee(String employeeJSON) {
        return new Gson().fromJson(employeeJSON, Employee.class);
    }

}
