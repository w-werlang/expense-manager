package com.wwerlang.learnspringhibernate.controller;

import com.google.gson.Gson;
import com.wwerlang.learnspringhibernate.domain.Category;
import com.wwerlang.learnspringhibernate.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> find(@PathVariable int id) {
        Category category = categoryService.find(id);
        return ResponseEntity.ok(category);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> list() {
        List<Category> categories = categoryService.list();
        return ResponseEntity.ok(categories);
    }

    @PostMapping("/category")
    public ResponseEntity<Category> save(@RequestBody String categoryJSON) {
        Category category = parseCategory(categoryJSON);
        category = categoryService.save(category);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/category")
    public void delete(@RequestBody String categoryJSON) {
        Category category = parseCategory(categoryJSON);
        categoryService.delete(category);
    }

    private Category parseCategory(String categoryJSON) {
        return new Gson().fromJson(categoryJSON, Category.class);
    }

}
