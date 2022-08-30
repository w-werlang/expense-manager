package com.wwerlang.learnspringhibernate.repository;

import com.wwerlang.learnspringhibernate.domain.Department;
import com.wwerlang.learnspringhibernate.repository.abs.AbstractRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class DepartmentRepository extends AbstractRepository {

    public Department find(int id) {
        return em.find(Department.class, id);
    }

    public List<Department> list() {
        return em.createQuery("FROM department", Department.class).getResultList();
    }

    @Transactional
    public Department save(Department department) {
        if (department.getId() == 0) {
            em.persist(department);
        } else {
            department = em.merge(department);
        }

        em.flush();
        em.refresh(department);
        return department;
    }

    @Transactional
    public void delete(Department department) {
        department = em.contains(department) ? department : em.merge(department);
        em.remove(department);
        em.flush();
    }

}
