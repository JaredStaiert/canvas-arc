package org.jaredstaiert.rpg_toolbackend.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.jaredstaiert.rpg_toolbackend.entities.Timeline;

@Entity
@Table(name = "timelinecharacters")
public class Timelinecharacter {
    @EmbeddedId
    private TimelinecharacterId id;

    @MapsId("timelineId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "timeline_id", nullable = false)
    private Timeline timeline;

    public TimelinecharacterId getId() {
        return id;
    }

    public void setId(TimelinecharacterId id) {
        this.id = id;
    }

    public Timeline getTimeline() {
        return timeline;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }

}