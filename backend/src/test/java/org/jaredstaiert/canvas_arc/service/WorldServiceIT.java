package org.jaredstaiert.canvas_arc.service;

import org.jaredstaiert.canvas_arc.world.WorldRepository;
import org.jaredstaiert.canvas_arc.world.WorldService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


@SpringBootTest
@ActiveProfiles("test")
public class WorldServiceIT {

    @Mock
    private WorldRepository worldRepository;
    @InjectMocks
    private WorldService worldService;

    private AutoCloseable mocks;


}
