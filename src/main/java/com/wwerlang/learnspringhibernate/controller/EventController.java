package com.wwerlang.learnspringhibernate.controller;

import com.google.gson.Gson;
import com.wwerlang.learnspringhibernate.domain.Event;
import com.wwerlang.learnspringhibernate.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class EventController {

    @Autowired
    EventService eventService;

    @GetMapping("/event/{id}")
    public ResponseEntity<Event> find(@PathVariable int id) {
        Event event = eventService.find(id);
        return ResponseEntity.ok(event);
    }

    @GetMapping("/event")
    public ResponseEntity<List<Event>> list() {
        List<Event> events = eventService.list();
        return ResponseEntity.ok(events);
    }

    @PostMapping("/event")
    public ResponseEntity<Event> save(@RequestBody String eventJSON) {
        Event event = parseEvent(eventJSON);
        event = eventService.save(event);
        return ResponseEntity.ok(event);
    }

    @DeleteMapping("/event")
    public void delete(@RequestBody String eventJSON) {
        Event event = parseEvent(eventJSON);
        eventService.delete(event);
    }

    private Event parseEvent(String eventJSON) {
        return new Gson().fromJson(eventJSON, Event.class);
    }

}
