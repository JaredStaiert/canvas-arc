package org.jaredstaiert.rpg_toolbackend.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "worlds")
public class World {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "world_id", nullable = false)
    private Integer id;

    @Column(name = "date_created")
    private LocalDate dateCreated;

    @Column(name = "world_name", length = Integer.MAX_VALUE)
    private String worldName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

}