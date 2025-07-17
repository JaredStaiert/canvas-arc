package org.jaredstaiert.rpg_toolbackend.repositories;

import org.jaredstaiert.rpg_toolbackend.timeline.Timeline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimelineRepository extends JpaRepository<Timeline, Integer> {
}
