package org.jaredstaiert.canvas_arc;

import org.jaredstaiert.canvas_arc.world.World;
import org.jaredstaiert.canvas_arc.world.WorldDTO;
import org.jaredstaiert.canvas_arc.world.WorldRepository;
import org.jaredstaiert.canvas_arc.world.WorldService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
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
    void testGetWorldById_returnsDTO() {
        // Arrange
        int testWorldId = 1;

        World mockWorld = new World();
        mockWorld.setWorldID(testWorldId);
        when(worldRepository.findById(testWorldId))
                .thenReturn(java.util.Optional.of(mockWorld));

        // Act
        WorldDTO result = worldService.getWorldById(testWorldId);

        // Assert
        assertThat(result).isNotNull();
        assertInstanceOf(WorldDTO.class, result);
        verify(worldRepository).findById(testWorldId);
    }

    @Test
    void testGetWorldById_returnsCorrectWorld() {
        // Arrange
        int testWorldId = 1;
        LocalDate testDate = LocalDate.of(2025, 8, 22);

        World mockWorld = new World("name", "world", testDate, "desc");
        mockWorld.setWorldID(testWorldId);

        when(worldRepository.findById(testWorldId))
                .thenReturn(java.util.Optional.of(mockWorld));

        WorldDTO baselineDTO = new WorldDTO(
                testWorldId,
                "name",
                "world",
                testDate,
                "desc");

        // Act
        WorldDTO result = worldService.getWorldById(testWorldId);

        // Assert
        assertThat(result).isNotNull();
        assertEquals(result, baselineDTO, "DTO should contain same data as Entity");
        verify(worldRepository).findById(testWorldId);
    }


    @Test
    void testGetAllWorlds_returnsTypeList() {
        int id1 = 1;
        int id2 = 2;

        World mockWorld1 = new World();
        mockWorld1.setWorldID(id1);
        World mockWorld2 = new World();
        mockWorld2.setWorldID(id2);
        //TODO: Write test after return type of WorldService.getAllWorlds is changed to WorldDTO
    }

    @Test
    void testGetAllWorlds_returnsListDTO() {
        //Arrange

    }

    @Test
    void testGetAllWorlds_returnsCorrectWorlds() {

    }

//    @Test
//    void testCreateWorld_savesWorld() {
//        // Arrange
//        WorldDTO newWorld = new WorldDTO(1,"", "World Name", LocalDate.now(), "");
//
//        when(worldRepository.save(any(World.class))).thenReturn(newWorld);
//
//        // Act
//        World result = worldService.saveWorld(newWorld);
//
//        // Assert
//        assertThat(result.getName()).isEqualTo("Arcane Realm");
//        verify(worldRepository).save(newWorld);
//    }
}
