package org.jaredstaiert.rpg_toolbackend.services;

import org.jaredstaiert.rpg_toolbackend.entities.Events;
import org.jaredstaiert.rpg_toolbackend.repositories.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventsService {

    @Autowired
    private EventsRepository eventsRepository;

    public List<Events> getAllEvents() {
        return eventsRepository.findAll();
    }
}
