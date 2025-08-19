package org.jaredstaiert.canvas_arc.world;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorldService {

    private final WorldRepository worldRepository;

    public WorldService(WorldRepository worldRepository) {
        this.worldRepository = worldRepository;
    }

    public List<World> getAllWorlds() {
        return worldRepository.findAll();
    }

    public World getWorldById(Integer id) {
        return worldRepository.findById(id).orElse(null);
    }

}
