package org.jaredstaiert.rpg_toolbackend;

import org.jaredstaiert.rpg_toolbackend.auth.AuthController;
import org.jaredstaiert.rpg_toolbackend.character.CharacterController;
import org.jaredstaiert.rpg_toolbackend.event.EventController;
import org.jaredstaiert.rpg_toolbackend.location.LocationController;
import org.jaredstaiert.rpg_toolbackend.timeline.TimelineController;
import org.jaredstaiert.rpg_toolbackend.world.WorldController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@WebMvcTest
public class ControllerSmokeTest {

    @Autowired
    private AuthController authController;
    @Autowired
    private CharacterController characterController;
    @Autowired
    private EventController eventController;
    @Autowired
    private LocationController locationController;
    @Autowired
    private TimelineController timelineController;
    @Autowired
    private WorldController worldController;

    @Test
    void contextLoads() throws Exception {
        assertThat(authController).isNotNull();
        assertThat(characterController).isNotNull();
        assertThat(eventController).isNotNull();
        assertThat(locationController).isNotNull();
        assertThat(timelineController).isNotNull();
        assertThat(worldController).isNotNull();
    }


}
