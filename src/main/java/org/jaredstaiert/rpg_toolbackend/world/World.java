package org.jaredstaiert.rpg_toolbackend.world;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "worlds")
public class World {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "world_id", nullable = false)
    private Integer worldID;

    @Column(name = "date_created")
    private LocalDate dateCreated;

    @Column(name = "world_name", length = Integer.MAX_VALUE)
    private String worldName;

    @Column(name = "world_desc", length = Integer.MAX_VALUE)
    private String worldDesc;

    public Integer getWorldID() {
        return worldID;
    }

    public void setWorldID(Integer id) {
        this.worldID = id;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getWorldName() {
        return worldName;
    }

    public void setWorldName(String worldName) {
        this.worldName = worldName;
    }

    public String getWorldDesc() {
        return worldDesc;
    }

    public void setWorldDesc(String worldDesc) {
        this.worldDesc = worldDesc;
    }
}