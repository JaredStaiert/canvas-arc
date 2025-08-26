package org.jaredstaiert.canvas_arc.service;

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
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
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
    void testGetWorldById_returnsCorrectWorld() {
        int testWorldId = 1;
        LocalDate testDate = LocalDate.of(2025, 8, 22);

        World mockWorld = new World("name", "world", testDate, "desc");
        mockWorld.setWorldID(testWorldId);
        when(worldRepository.findById(testWorldId))
                .thenReturn(java.util.Optional.of(mockWorld));

        WorldDTO result = worldService.getWorldById(testWorldId);

        assertThat(result).isNotNull();
        assertEquals(result.worldId(), mockWorld.getWorldID());
        assertEquals(result.userName(), mockWorld.getUserName());
        assertEquals(result.worldName(), mockWorld.getWorldName());
        assertEquals(result.dateCreated(), mockWorld.getDateCreated());
        assertEquals(result.worldDesc(), mockWorld.getWorldDesc());
        verify(worldRepository).findById(testWorldId);
    }


    @Test
    void testGetAllWorlds_returnsCorrectWorlds() {
        int id1 = 1;
        int id2 = 2;
        LocalDate testDate = LocalDate.of(2025, 8, 22);

        World mockWorld = new World("", "", testDate, "");
        mockWorld.setWorldID(id1);
        World mockWorld2 = new World("", "", testDate, "");
        mockWorld2.setWorldID(id2);

        List<World> baselineWorldList = Arrays.asList(mockWorld, mockWorld2);
        when(worldRepository.findAll())
                .thenReturn(baselineWorldList);

        List<WorldDTO> resultWorldDTOList = worldService.getAllWorlds();

        assertThat(resultWorldDTOList).isNotNull();
        assertInstanceOf(List.class, resultWorldDTOList);
        for (int i = 0; i < resultWorldDTOList.size(); i++) {
            assertEquals(resultWorldDTOList.get(i).worldId(), baselineWorldList.get(i).getWorldID());
            assertEquals(resultWorldDTOList.get(i).userName(), baselineWorldList.get(i).getUserName());
            assertEquals(resultWorldDTOList.get(i).worldName(), baselineWorldList.get(i).getWorldName());
            assertEquals(resultWorldDTOList.get(i).dateCreated(), baselineWorldList.get(i).getDateCreated());
            assertEquals(resultWorldDTOList.get(i).worldDesc(), baselineWorldList.get(i).getWorldDesc());
        }
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
