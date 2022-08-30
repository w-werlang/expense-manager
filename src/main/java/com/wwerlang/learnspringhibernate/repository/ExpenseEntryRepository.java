package com.wwerlang.learnspringhibernate.repository;

import com.wwerlang.learnspringhibernate.domain.ExpenseEntry;
import com.wwerlang.learnspringhibernate.repository.abs.AbstractRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ExpenseEntryRepository extends AbstractRepository {

    public ExpenseEntry find(int id) {
        return em.find(ExpenseEntry.class, id);
    }

    public List<ExpenseEntry> list() {
        return em.createQuery("FROM expenseEntry_report", ExpenseEntry.class).getResultList();
    }

    @Transactional
    public ExpenseEntry save(ExpenseEntry expenseEntry) {
        if (expenseEntry.getId() == 0) {
            em.persist(expenseEntry);
        } else {
            expenseEntry = em.merge(expenseEntry);
        }

        em.flush();
        em.refresh(expenseEntry);
        return expenseEntry;
    }

    @Transactional
    public void delete(ExpenseEntry expenseEntry) {
        expenseEntry = em.contains(expenseEntry) ? expenseEntry : em.merge(expenseEntry);
        em.remove(expenseEntry);
        em.flush();
    }

}
