package org.jaredstaiert.rpg_toolbackend.world;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorldRepository extends JpaRepository<World, Integer> {
}
