package org.jaredstaiert.rpg_toolbackend.character;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {
    List<CharacterSummary> findAllProjectedBy();
}
