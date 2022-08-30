package com.wwerlang.learnspringhibernate.controller;

import com.google.gson.Gson;
import com.wwerlang.learnspringhibernate.domain.ExpenseReport;
import com.wwerlang.learnspringhibernate.service.ExpenseReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpenseReportController {

    @Autowired
    ExpenseReportService expenseReportService;

    @GetMapping("/expenseReport/{id}")
    public ResponseEntity<ExpenseReport> find(@PathVariable int id) {
        ExpenseReport expenseReport = expenseReportService.find(id);
        return ResponseEntity.ok(expenseReport);
    }

    @GetMapping("/expenseReport")
    public ResponseEntity<List<ExpenseReport>> list() {
        List<ExpenseReport> expenseReports = expenseReportService.list();
        return ResponseEntity.ok(expenseReports);
    }

    @PostMapping("/expenseReport")
    public ResponseEntity<ExpenseReport> save(@RequestBody String expenseReportJSON) {
        ExpenseReport expenseReport = parseExpenseReport(expenseReportJSON);
        expenseReport = expenseReportService.save(expenseReport);
        return ResponseEntity.ok(expenseReport);
    }

    @DeleteMapping("/expenseReport")
    public void delete(@RequestBody String expenseReportJSON) {
        ExpenseReport expenseReport = parseExpenseReport(expenseReportJSON);
        expenseReportService.delete(expenseReport);
    }

    private ExpenseReport parseExpenseReport(String expenseReportJSON) {
        return new Gson().fromJson(expenseReportJSON, ExpenseReport.class);
    }

}
