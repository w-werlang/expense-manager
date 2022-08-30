package com.wwerlang.learnspringhibernate.service;

import com.wwerlang.learnspringhibernate.domain.Department;
import com.wwerlang.learnspringhibernate.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    public Department find(int id) {
        return repository.find(id);
    }

    public List<Department> list() {
        return repository.list();
    }

    public Department save(Department department) {
        return repository.save(department);
    }

    public void delete(Department department) {
        repository.delete(department);
    }

}