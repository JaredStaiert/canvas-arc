package org.jaredstaiert.rpg_toolbackend.services;

import org.jaredstaiert.rpg_toolbackend.dto.EventProj;
import org.jaredstaiert.rpg_toolbackend.entities.Event;
import org.jaredstaiert.rpg_toolbackend.repositories.EventRepository;
import org.jaredstaiert.rpg_toolbackend.repositories.TimelineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final TimelineRepository timelineRepository;

    public EventService(EventRepository eventRepository, TimelineRepository timelineRepository) {
        this.eventRepository = eventRepository;
        this.timelineRepository = timelineRepository;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    /**
     * Returns Event DTO List, but replaces timeline_id and location_id entries with their
     * more meaningful name fields.
     * @return List of Event DTO objects
     */
    public List<EventProj> getAllEventsWithTranslatedID() {
        return eventRepository.findAllEventsTest();
    }

    public Optional<Event> getEventById(int id) {
        return eventRepository.findById(id);
    }

    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }
}
