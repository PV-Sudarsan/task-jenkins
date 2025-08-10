package com.example.springapp.service;


import com.example.springapp.entity.Event;
import com.example.springapp.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository repo;

    public List<Event> getAll() {
        return repo.findAll();
    }

    public Event save(Event e) {
        return repo.save(e);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Event update(Long id, Event newEvent) {
        Event old = repo.findById(id).orElseThrow();
        old.setName(newEvent.getName());
        old.setPlace(newEvent.getPlace());
        return repo.save(old);
    }
}