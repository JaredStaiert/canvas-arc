package org.jaredstaiert.rpg_toolbackend.event;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/all-events")
    public List<EventProj> getAllEvents() {
        return eventService.getAllEventsWithTranslatedID();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable int id) {
        return eventService.getEventById(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/save/{event}")
    public ResponseEntity<Event> saveEvent(@RequestBody Event event) {
        Event savedEvent = eventService.saveEvent(event);
        return ResponseEntity.ok(savedEvent);
    }

}