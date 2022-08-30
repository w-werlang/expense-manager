package com.wwerlang.learnspringhibernate.controller;

import com.google.gson.Gson;
import com.wwerlang.learnspringhibernate.domain.ExpenseEntry;
import com.wwerlang.learnspringhibernate.service.ExpenseEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpenseEntryController {

    @Autowired
    ExpenseEntryService expenseEntryService;

    @GetMapping("/expenseEntry/{id}")
    public ResponseEntity<ExpenseEntry> find(@PathVariable int id) {
        ExpenseEntry expenseEntry = expenseEntryService.find(id);
        return ResponseEntity.ok(expenseEntry);
    }

    @GetMapping("/expenseEntry")
    public ResponseEntity<List<ExpenseEntry>> list() {
        List<ExpenseEntry> expenseEntries = expenseEntryService.list();
        return ResponseEntity.ok(expenseEntries);
    }

    @PostMapping("/expenseEntry")
    public ResponseEntity<ExpenseEntry> save(@RequestBody String expenseEntryJSON) {
        ExpenseEntry expenseEntry = parseExpenseEntry(expenseEntryJSON);
        expenseEntry = expenseEntryService.save(expenseEntry);
        return ResponseEntity.ok(expenseEntry);
    }

    @DeleteMapping("/expenseEntry")
    public void delete(@RequestBody String expenseEntryJSON) {
        ExpenseEntry expenseEntry = parseExpenseEntry(expenseEntryJSON);
        expenseEntryService.delete(expenseEntry);
    }

    private ExpenseEntry parseExpenseEntry(String expenseEntryJSON) {
        return new Gson().fromJson(expenseEntryJSON, ExpenseEntry.class);
    }

}
