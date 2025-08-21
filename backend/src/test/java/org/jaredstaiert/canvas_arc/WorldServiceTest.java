package org.jaredstaiert.canvas_arc;

import org.jaredstaiert.canvas_arc.world.World;
import org.jaredstaiert.canvas_arc.world.WorldRepository;
import org.jaredstaiert.canvas_arc.world.WorldService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

public class WorldServiceTest {

    @Mock
    private WorldRepository worldRepository;
    @InjectMocks
    private WorldService worldService;

    private AutoCloseable mocks;

    @BeforeEach
    void setUp() {
       mocks = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        mocks.close();
    }

    @Test
    void testFindWorldById_returnsWorld() {
        // Arrange
        int worldId = 1;
        World mockWorld = new World("", "", LocalDate.now(), "");
        mockWorld.setWorldID(worldId);
        when(worldRepository.findById(worldId)).thenReturn(java.util.Optional.of(mockWorld));

        // Act
        World result = worldService.getWorldById(worldId);

        // Assert
        assertThat(result).isNotNull();
        assertThat(result.getWorldID()).isEqualTo(worldId);
        verify(worldRepository).findById(worldId);
    }
}
