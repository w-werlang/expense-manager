package com.wwerlang.learnspringhibernate.repository;

import com.wwerlang.learnspringhibernate.domain.Employee;
import com.wwerlang.learnspringhibernate.repository.abs.AbstractRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class EmployeeRepository extends AbstractRepository {

    public Employee find(int id) {
        return em.find(Employee.class, id);
    }

    public List<Employee> list() {
        return em.createQuery("FROM employee", Employee.class).getResultList();
    }

    @Transactional
    public Employee save(Employee employee) {
        if (employee.getId() == 0) {
            em.persist(employee);
        } else {
            employee = em.merge(employee);
        }

        em.flush();
        em.refresh(employee);
        return employee;
    }

    @Transactional
    public void delete(Employee employee) {
        employee = em.contains(employee) ? employee : em.merge(employee);
        em.remove(employee);
        em.flush();
    }

}
