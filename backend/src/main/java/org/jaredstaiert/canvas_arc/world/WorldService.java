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

    public WorldDTO saveWorld(WorldDTO worldInfo) {
        World newWorld = new World(
                worldInfo.user_name(),
                worldInfo.world_name(),
                worldInfo.date_created(),
                worldInfo.world_desc());

        World success = worldRepository.save(newWorld);
        return new WorldDTO(
                success.getUserName(),
                success.getWorldName(),
                success.getDateCreated(),
                success.getWorldDesc());
    }
}
