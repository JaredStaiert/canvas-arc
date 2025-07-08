package org.jaredstaiert.rpg_toolbackend.repositories;

import org.jaredstaiert.rpg_toolbackend.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
}
