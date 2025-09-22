package org.jaredstaiert.canvas_arc.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

    @Query(value = """
                    SELECT e.event_id AS eventID, e.timeline_id AS timelineID, l.location_name AS locationName,
                            e.event_name AS eventName, e.event_type AS eventType, e.event_focus AS eventFocus,
                            e.event_date AS eventDate, e.event_outcome AS eventOutcome, e.event_consequence AS eventConsequence
                    FROM events e
                    INNER JOIN locations l ON e.location_id = l.location_id;
            """, nativeQuery = true)
    List<EventHumanReadable> findEventsHumanReadable();
}