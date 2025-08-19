package org.jaredstaiert.canvas_arc;

import org.jaredstaiert.canvas_arc.world.WorldController;
import org.jaredstaiert.canvas_arc.world.WorldService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

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
