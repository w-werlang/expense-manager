package com.wwerlang.learnspringhibernate.service;

import com.wwerlang.learnspringhibernate.domain.ExpenseEntry;
import com.wwerlang.learnspringhibernate.domain.ExpenseReport;
import com.wwerlang.learnspringhibernate.repository.ExpenseEntryRepository;
import com.wwerlang.learnspringhibernate.repository.ExpenseReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ExpenseReportService {

    @Autowired
    private ExpenseReportRepository repository;

    @Autowired
    private ExpenseEntryRepository expenseEntryRepository;

    public ExpenseReport find(int id) {
        return repository.find(id);
    }

    public List<ExpenseReport> list() {
        return repository.list();
    }

    public ExpenseReport save(ExpenseReport expenseReport) {
        setTotalAmount(expenseReport);
        setExpenseEntryReference(expenseReport);
        return repository.save(expenseReport);
    }

    public void delete(ExpenseReport expenseReport) {
        repository.delete(expenseReport);
    }

    private void setTotalAmount(ExpenseReport expenseReport) {
        BigDecimal calculatedAmount = BigDecimal.ZERO;

        for (ExpenseEntry expenseEntry : expenseReport.getExpenseEntries()) {
            calculatedAmount = calculatedAmount.add(expenseEntry.getAmount());
        }

        expenseReport.setTotalAmount(calculatedAmount);
    }

    private void setExpenseEntryReference(ExpenseReport expenseReport) {
        for (ExpenseEntry expenseEntry : expenseReport.getExpenseEntries()) {
            expenseEntry.setExpenseReport(expenseReport);
        }
    }

}
