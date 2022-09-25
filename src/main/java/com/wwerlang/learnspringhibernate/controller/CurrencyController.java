package com.wwerlang.learnspringhibernate.controller;

import com.google.gson.Gson;
import com.wwerlang.learnspringhibernate.domain.Currency;
import com.wwerlang.learnspringhibernate.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CurrencyController {

    @Autowired
    CurrencyService currencyService;

    @GetMapping("/currency/{id}")
    public ResponseEntity<Currency> find(@PathVariable int id) {
        Currency currency = currencyService.find(id);
        return ResponseEntity.ok(currency);
    }

    @GetMapping("/currency")
    public ResponseEntity<List<Currency>> list() {
        List<Currency> currencies = currencyService.list();
        return ResponseEntity.ok(currencies);
    }

    @PostMapping("/currency")
    public ResponseEntity<Currency> save(@RequestBody String currencyJSON) {
        Currency currency = parseCurrency(currencyJSON);
        currency = currencyService.save(currency);
        return ResponseEntity.ok(currency);
    }

    @DeleteMapping("/currency")
    public void delete(@RequestBody String currencyJSON) {
        Currency currency = parseCurrency(currencyJSON);
        currencyService.delete(currency);
    }

    private Currency parseCurrency(String currencyJSON) {
        return new Gson().fromJson(currencyJSON, Currency.class);
    }

}
