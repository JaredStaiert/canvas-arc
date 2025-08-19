package org.jaredstaiert.canvas_arc.timelinecharacter;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.jaredstaiert.canvas_arc.timeline.Timeline;
import org.jaredstaiert.canvas_arc.character.Character;

@Entity
@Table(name = "timelinecharacters")
public class Timelinecharacter {
    @EmbeddedId
    private TimelinecharacterId timelineCharacterId;

    @MapsId("timelineId")
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "timeline_id", nullable = false)
    private Timeline timeline;

    @MapsId("characterId")
    @ManyToOne
    @JoinColumn(name = "character_id", nullable = false)
    private Character character;

    public TimelinecharacterId getTimelineCharacterId() {
        return timelineCharacterId;
    }

    public void setTimelineCharacterId(TimelinecharacterId id) {
        this.timelineCharacterId = id;
    }

    public Timeline getTimeline() {
        return timeline;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }

}