package com.wwerlang.learnspringhibernate.service;

import com.wwerlang.learnspringhibernate.domain.ExpenseEntry;
import com.wwerlang.learnspringhibernate.repository.ExpenseEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseEntryService {

    @Autowired
    private ExpenseEntryRepository repository;

    public ExpenseEntry find(int id) {
        return repository.find(id);
    }

    public List<ExpenseEntry> list() {
        return repository.list();
    }

    public ExpenseEntry save(ExpenseEntry expenseEntry) {
        return repository.save(expenseEntry);
    }

    public void delete(ExpenseEntry expenseEntry) {
        repository.delete(expenseEntry);
    }

}
