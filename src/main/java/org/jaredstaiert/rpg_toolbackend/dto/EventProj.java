package org.jaredstaiert.rpg_toolbackend.dto;

import org.jaredstaiert.rpg_toolbackend.entities.Timeline;

import java.time.LocalDate;

public interface EventProj {
    int getEventId();
    Timeline getTimeline();
    String getLocationName();
    String getEventName();
    String getEventType();
    String getEventFocus();
    LocalDate getEventData();
    String getEventOutcome();
    String getEventConsequence();

}
