package org.jaredstaiert.rpg_toolbackend.timeline;

import jakarta.persistence.*;
import org.jaredstaiert.rpg_toolbackend.world.World;

import java.time.LocalDate;

@Entity
@Table(name = "timelines")
public class Timeline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "timeline_id", nullable = false)
    private Integer id;

//    @ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne()
    @JoinColumn(name = "world_id")
    private World world;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "timeline_name")
    private String timelineName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getTimelineName() {
        return timelineName;
    }

    public void setTimelineName(String timelineName) {
        this.timelineName = timelineName;
    }
}