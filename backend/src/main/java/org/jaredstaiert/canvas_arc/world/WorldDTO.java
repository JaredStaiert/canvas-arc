package org.jaredstaiert.canvas_arc.world;

import java.time.LocalDate;

public record WorldDTO(
        Integer worldId,
        String userName,
        String worldName,
        LocalDate dateCreated,
        String worldDesc) {
}
