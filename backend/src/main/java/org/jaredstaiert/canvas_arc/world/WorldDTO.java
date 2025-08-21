package org.jaredstaiert.canvas_arc.world;

import java.time.LocalDate;

public record WorldDTO(
        String user_name,
        String world_name,
        LocalDate date_created,
        String world_desc) {
}
