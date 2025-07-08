package org.jaredstaiert.rpg_toolbackend;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.jaredstaiert.rpg_toolbackend.entities.Timelines;

@Entity
@Table(name = "timelinecharacters")
public class Timelinecharacter {
    @EmbeddedId
    private TimelinecharacterId id;

    @MapsId("timelineId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "timeline_id", nullable = false)
    private Timelines timeline;

    public TimelinecharacterId getId() {
        return id;
    }

    public void setId(TimelinecharacterId id) {
        this.id = id;
    }

    public Timelines getTimeline() {
        return timeline;
    }

    public void setTimeline(Timelines timeline) {
        this.timeline = timeline;
    }

}