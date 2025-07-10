package org.jaredstaiert.rpg_toolbackend.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;

    @ColumnDefault("'event_name'")
    @Column(name = "event_name", nullable = false, length = Integer.MAX_VALUE)
    private String eventName;

    @ColumnDefault("'event_type'")
    @Column(name = "event_type", nullable = false, length = Integer.MAX_VALUE)
    private String eventType;

    @ColumnDefault("'event_focus'")
    @Column(name = "event_focus", nullable = false, length = Integer.MAX_VALUE)
    private String eventFocus;

    @Column(name = "event_date")
    private LocalDate eventDate;

    @ColumnDefault("'event_outcome'")
    @Column(name = "event_outcome", nullable = false, length = Integer.MAX_VALUE)
    private String eventOutcome;

    @ColumnDefault("'event_consequences'")
    @Column(name = "event_consequence", nullable = false, length = Integer.MAX_VALUE)
    private String eventConsequence;

//    @Column(name = "eventid", nullable = false)
//    private Integer eventid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventFocus() {
        return eventFocus;
    }

    public void setEventFocus(String eventFocus) {
        this.eventFocus = eventFocus;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventOutcome() {
        return eventOutcome;
    }

    public void setEventOutcome(String eventOutcome) {
        this.eventOutcome = eventOutcome;
    }

    public String getEventConsequence() {
        return eventConsequence;
    }

    public void setEventConsequence(String eventConsequence) {
        this.eventConsequence = eventConsequence;
    }

//    public Integer getEventid() {
//        return eventid;
//    }

//    public void setEventid(Integer eventid) {
//        this.eventid = eventid;
//    }

}