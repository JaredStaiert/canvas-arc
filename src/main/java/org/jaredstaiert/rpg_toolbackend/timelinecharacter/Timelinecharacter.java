package org.jaredstaiert.rpg_toolbackend.timelinecharacter;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.jaredstaiert.rpg_toolbackend.timeline.Timeline;
import org.jaredstaiert.rpg_toolbackend.character.Character;

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