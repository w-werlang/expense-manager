package com.wwerlang.learnspringhibernate.service;

import com.wwerlang.learnspringhibernate.domain.Employee;
import com.wwerlang.learnspringhibernate.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public Employee find(int id) {
        return repository.find(id);
    }

    public List<Employee> list() {
        return repository.list();
    }

    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    public void delete(Employee employee) {
        repository.delete(employee);
    }

}
