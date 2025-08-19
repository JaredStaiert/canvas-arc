package org.jaredstaiert.canvas_arc.timeline;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimelineRepository extends JpaRepository<Timeline, Integer> {

    @Query(value = """
        SELECT DISTINCT ON (timeline_name) timeline_name
        FROM timelines;
    """, nativeQuery=true)
    List<String> findDistinctTimelineNames();
}
