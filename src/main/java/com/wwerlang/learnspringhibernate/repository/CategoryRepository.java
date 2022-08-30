package com.wwerlang.learnspringhibernate.repository;

import com.wwerlang.learnspringhibernate.domain.Category;
import com.wwerlang.learnspringhibernate.repository.abs.AbstractRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CategoryRepository extends AbstractRepository {

    public Category find(int id) {
        return em.find(Category.class, id);
    }

    public List<Category> list() {
        return em.createQuery("FROM category", Category.class).getResultList();
    }

    @Transactional
    public Category save(Category category) {
        if (category.getId() == 0) {
            em.persist(category);
        } else {
            category = em.merge(category);
        }

        em.flush();
        em.refresh(category);
        return category;
    }

    @Transactional
    public void delete(Category category) {
        category = em.contains(category) ? category : em.merge(category);
        em.remove(category);
        em.flush();
    }

}
