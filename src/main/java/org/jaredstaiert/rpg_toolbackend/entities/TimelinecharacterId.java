package org.jaredstaiert.rpg_toolbackend;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TimelinecharacterId implements Serializable {
    private static final long serialVersionUID = -7157644769021411475L;
    @Column(name = "timeline_id", nullable = false)
    private Integer timelineId;

    @Column(name = "character_id", nullable = false)
    private Integer characterId;

    public Integer getTimelineId() {
        return timelineId;
    }

    public void setTimelineId(Integer timelineId) {
        this.timelineId = timelineId;
    }

    public Integer getCharacterId() {
        return characterId;
    }

    public void setCharacterId(Integer characterId) {
        this.characterId = characterId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TimelinecharacterId entity = (TimelinecharacterId) o;
        return Objects.equals(this.timelineId, entity.timelineId) &&
                Objects.equals(this.characterId, entity.characterId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timelineId, characterId);
    }

}