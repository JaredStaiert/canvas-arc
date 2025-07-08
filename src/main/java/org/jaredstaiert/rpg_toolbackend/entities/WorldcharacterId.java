package org.jaredstaiert.rpg_toolbackend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class WorldcharacterId implements Serializable {
    private static final long serialVersionUID = -6901784418479847447L;
    @Column(name = "world_id", nullable = false)
    private Integer worldId;

    @Column(name = "character_id", nullable = false)
    private Integer characterId;

    public Integer getWorldId() {
        return worldId;
    }

    public void setWorldId(Integer worldId) {
        this.worldId = worldId;
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
        WorldcharacterId entity = (WorldcharacterId) o;
        return Objects.equals(this.worldId, entity.worldId) &&
                Objects.equals(this.characterId, entity.characterId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(worldId, characterId);
    }

}