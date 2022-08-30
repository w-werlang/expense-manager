package com.wwerlang.learnspringhibernate.controller;

import com.google.gson.Gson;
import com.wwerlang.learnspringhibernate.domain.Department;
import com.wwerlang.learnspringhibernate.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/department/{id}")
    public ResponseEntity<Department> find(@PathVariable int id) {
        Department department = departmentService.find(id);
        return ResponseEntity.ok(department);
    }

    @GetMapping("/department")
    public ResponseEntity<List<Department>> list() {
        List<Department> departments = departmentService.list();
        return ResponseEntity.ok(departments);
    }

    @PostMapping("/department")
    public ResponseEntity<Department> save(@RequestBody String departmentJSON) {
        Department department = parseDepartment(departmentJSON);
        department = departmentService.save(department);
        return ResponseEntity.ok(department);
    }

    @DeleteMapping("/department")
    public void delete(@RequestBody String departmentJSON) {
        Department department = parseDepartment(departmentJSON);
        departmentService.delete(department);
    }

    private Department parseDepartment(String departmentJSON) {
        return new Gson().fromJson(departmentJSON, Department.class);
    }

}
