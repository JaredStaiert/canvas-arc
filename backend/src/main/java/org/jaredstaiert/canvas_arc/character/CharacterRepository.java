package org.jaredstaiert.canvas_arc.character;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {
    @Query(value = """
                SELECT DISTINCT c.character_id,
                                c.user_name,
                                c.character_name,
                                c.character_age,
                                c.character_bio,
                                w.world_name,
                                STRING_AGG(t.timeline_name, ', ') AS timeline_name
                FROM characters c
                         LEFT JOIN timelinecharacters tc ON c.character_id = tc.character_id
                         LEFT JOIN timelines t ON tc.timeline_id = t.timeline_id
                         LEFT JOIN worldcharacters wc ON c.character_id = wc.character_id
                         LEFT JOIN worlds w ON wc.world_id = w.world_id
                GROUP BY c.character_id, c.user_name, c.character_name, c.character_age, c.character_bio, w.world_name;
            """, nativeQuery = true)
    List<CharacterSummary> findAllProjectedBy();
}
