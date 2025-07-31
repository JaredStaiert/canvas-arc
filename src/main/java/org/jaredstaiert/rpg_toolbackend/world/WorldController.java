package org.jaredstaiert.rpg_toolbackend.world;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/worlds")
public class WorldController {

    private final WorldService worldService;

    public WorldController(WorldService worldService) {
        this.worldService = worldService;
    }

    @GetMapping("/all-worlds")
    public List<World> getAllWorlds() {
        return worldService.getAllWorlds();
    }

    @GetMapping("/edit/get/{id}")
    public World getWorldToEdit(@PathVariable Integer id) {
        return worldService.getWorldById(id);
    }

}