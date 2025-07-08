package org.jaredstaiert.rpg_toolbackend.services;

import org.jaredstaiert.rpg_toolbackend.entities.Event;
import org.jaredstaiert.rpg_toolbackend.repositories.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
}
