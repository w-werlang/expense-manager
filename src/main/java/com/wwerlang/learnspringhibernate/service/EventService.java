package com.wwerlang.learnspringhibernate.service;

import com.wwerlang.learnspringhibernate.domain.Event;
import com.wwerlang.learnspringhibernate.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    public Event find(int id) {
        return repository.find(id);
    }

    public List<Event> list() {
        return repository.list();
    }

    public Event save(Event event) {
        return repository.save(event);
    }

    public void delete(Event event) {
        repository.delete(event);
    }

}
