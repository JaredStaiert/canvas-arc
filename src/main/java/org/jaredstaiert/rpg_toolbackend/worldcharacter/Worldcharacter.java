package org.jaredstaiert.rpg_toolbackend.worldcharacter;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.jaredstaiert.rpg_toolbackend.entities.WorldcharacterId;
import org.jaredstaiert.rpg_toolbackend.world.World;

@Entity
@Table(name = "worldcharacters")
public class Worldcharacter {
    @EmbeddedId
    private WorldcharacterId id;

    @MapsId("worldId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "world_id", nullable = false)
    private World world;

    public WorldcharacterId getId() {
        return id;
    }

    public void setId(WorldcharacterId id) {
        this.id = id;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

}