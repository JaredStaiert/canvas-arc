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
        //TODO: convert return type to WorldDTO
        return worldRepository.findAll();
    }

    public WorldDTO getWorldById(Integer id) {
        World world = worldRepository.findById(id).orElse(null);

        if  (world == null) {
            return null;
        }

        return new WorldDTO(
                world.getWorldID(),
                world.getUserName(),
                world.getWorldName(),
                world.getDateCreated(),
                world.getWorldDesc()
        );
    }

    public WorldDTO saveWorld(WorldDTO worldInfo) {
        World newWorld = new World(
                worldInfo.user_name(),
                worldInfo.world_name(),
                worldInfo.date_created(),
                worldInfo.world_desc());

        World success = worldRepository.save(newWorld);
        return new WorldDTO(
                success.getWorldID(),
                success.getUserName(),
                success.getWorldName(),
                success.getDateCreated(),
                success.getWorldDesc()
        );
    }
}
