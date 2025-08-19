package org.jaredstaiert.rpg_toolbackend;

import org.jaredstaiert.rpg_toolbackend.world.WorldController;
import org.jaredstaiert.rpg_toolbackend.world.WorldService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;

@WebMvcTest(WorldController.class)
public class WebMockTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private WorldService worldService;

    @Test
    void shouldReturnFromService() throws Exception {

    }
}
