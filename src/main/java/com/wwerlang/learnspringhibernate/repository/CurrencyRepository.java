package com.wwerlang.learnspringhibernate.repository;

import com.wwerlang.learnspringhibernate.domain.Currency;
import com.wwerlang.learnspringhibernate.repository.abs.AbstractRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CurrencyRepository extends AbstractRepository {

    public Currency find(int id) {
        return em.find(Currency.class, id);
    }

    public List<Currency> list() {
        return em.createQuery("FROM currency", Currency.class).getResultList();
    }

    @Transactional
    public Currency save(Currency currency) {
        if (currency.getId() == 0) {
            em.persist(currency);
        } else {
            currency = em.merge(currency);
        }

        em.flush();
        em.refresh(currency);
        return currency;
    }

    @Transactional
    public void delete(Currency currency) {
        currency = em.contains(currency) ? currency : em.merge(currency);
        em.remove(currency);
        em.flush();
    }

}
