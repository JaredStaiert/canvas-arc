package org.jaredstaiert.canvas_arc.world;

import org.springframework.http.ResponseEntity;
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
    public List<WorldDTO> getAllWorlds() {
        return worldService.getAllWorlds();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorldDTO> getWorldById(@PathVariable Integer id) {
        WorldDTO response = worldService.getWorldById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/edit/get/{id}")
    public WorldDTO getWorldToEdit(@PathVariable Integer id) {
        return worldService.getWorldById(id);
    }

    @PostMapping("/save")
    public WorldDTO saveWorld(@RequestBody WorldDTO worldDTO) {
        return worldService.saveWorld(worldDTO);
    }

}