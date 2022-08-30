package com.wwerlang.learnspringhibernate.service;

import com.wwerlang.learnspringhibernate.domain.Currency;
import com.wwerlang.learnspringhibernate.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyRepository repository;

    public Currency find(int id) {
        return repository.find(id);
    }

    public List<Currency> list() {
        return repository.list();
    }

    public Currency save(Currency currency) {
        return repository.save(currency);
    }

    public void delete(Currency currency) {
        repository.delete(currency);
    }

}
