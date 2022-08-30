package com.wwerlang.learnspringhibernate.repository;

import com.wwerlang.learnspringhibernate.domain.ExpenseReport;
import com.wwerlang.learnspringhibernate.repository.abs.AbstractRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ExpenseReportRepository extends AbstractRepository {

    public ExpenseReport find(int id) {
        return em.find(ExpenseReport.class, id);
    }

    public List<ExpenseReport> list() {
        return em.createQuery("FROM expense_report", ExpenseReport.class).getResultList();
    }

    @Transactional
    public ExpenseReport save(ExpenseReport expenseReport) {
        if (expenseReport.getId() == 0) {
            em.persist(expenseReport);
        } else {
            expenseReport = em.merge(expenseReport);
        }

        em.flush();
        em.refresh(expenseReport);
        return expenseReport;
    }

    @Transactional
    public void delete(ExpenseReport expenseReport) {
        expenseReport = em.contains(expenseReport) ? expenseReport : em.merge(expenseReport);
        em.remove(expenseReport);
        em.flush();
    }

}
