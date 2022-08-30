package com.wwerlang.learnspringhibernate.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "expense_report")
@Table(name = "expense_report")
public class ExpenseReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @OneToMany(mappedBy = "expenseReport", cascade = CascadeType.PERSIST)
    private List<ExpenseEntry> expenseEntries = new ArrayList<>();

    public void calculateTotalAmount() {
        BigDecimal calculatedAmount = BigDecimal.ZERO;

        for (ExpenseEntry expenseEntry : expenseEntries) {
            calculatedAmount = calculatedAmount.add(expenseEntry.getAmount());
        }

        totalAmount = calculatedAmount;
    }

}
