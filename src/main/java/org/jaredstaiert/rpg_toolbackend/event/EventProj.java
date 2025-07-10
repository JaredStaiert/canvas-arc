package org.jaredstaiert.rpg_toolbackend.event;

import org.jaredstaiert.rpg_toolbackend.entities.Timeline;

import java.time.LocalDate;

public interface EventProj {
    int getEventId();
    Timeline getTimeline();
    String getLocationName();
    String getEventName();
    String getEventType();
    String getEventFocus();
    LocalDate getEventDate();
    String getEventOutcome();
    String getEventConsequence();

}
