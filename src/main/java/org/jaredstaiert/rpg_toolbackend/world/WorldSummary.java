package org.jaredstaiert.rpg_toolbackend.world;

import java.time.LocalDate;

public interface WorldSummary {
    Integer getWorldId();
    LocalDate getDateCreated();
    String getWorldName();
    String getWorldDescription();
}
