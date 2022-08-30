package com.wwerlang.learnspringhibernate.repository;

import com.wwerlang.learnspringhibernate.domain.Event;
import com.wwerlang.learnspringhibernate.repository.abs.AbstractRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class EventRepository extends AbstractRepository {

    public Event find(int id) {
        return em.find(Event.class, id);
    }

    public List<Event> list() {
        return em.createQuery("FROM event", Event.class).getResultList();
    }

    @Transactional
    public Event save(Event event) {
        if (event.getId() == 0) {
            em.persist(event);
        } else {
            event = em.merge(event);
        }

        em.flush();
        em.refresh(event);
        return event;
    }

    @Transactional
    public void delete(Event event) {
        event = em.contains(event) ? event : em.merge(event);
        em.remove(event);
        em.flush();
    }

}
