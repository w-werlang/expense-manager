package com.wwerlang.learnspringhibernate.service;

import com.wwerlang.learnspringhibernate.domain.Category;
import com.wwerlang.learnspringhibernate.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public Category find(int id) {
        return repository.find(id);
    }

    public List<Category> list() {
        return repository.list();
    }

    public Category save(Category category) {
        return repository.save(category);
    }

    public void delete(Category category) {
        repository.delete(category);
    }

}
