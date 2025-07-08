package org.jaredstaiert.rpg_toolbackend.repositories;

import org.jaredstaiert.rpg_toolbackend.entities.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepository extends JpaRepository<Events, Integer> {
}
