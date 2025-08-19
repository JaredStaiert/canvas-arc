package org.jaredstaiert.canvas_arc.world;

import java.time.LocalDate;

public interface WorldSummary {
    Integer getWorldId();
    LocalDate getDateCreated();
    String getWorldName();
    String getWorldDescription();
}
