package org.jaredstaiert.canvas_arc.event;

import org.jaredstaiert.canvas_arc.timeline.Timeline;

import java.time.LocalDate;

public interface EventHumanReadable {
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
