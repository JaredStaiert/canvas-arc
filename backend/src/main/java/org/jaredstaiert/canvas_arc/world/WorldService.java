package org.jaredstaiert.canvas_arc.world;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorldService {

    private final WorldRepository worldRepository;

    public WorldService(WorldRepository worldRepository) {
        this.worldRepository = worldRepository;
    }

    /**
     * Gets all worlds in database.
     * @return List of WorldDTO objects.
     */
    public List<WorldDTO> getAllWorlds() {
        List<World> worlds = worldRepository.findAll();

        return worlds.stream()
                .map(world ->
                        new WorldDTO(world.getWorldID(),
                                world.getUserName(),
                                world.getWorldName(),
                                world.getDateCreated(),
                                world.getWorldDesc()))
                .toList();
    }

    /**
     * Gets world from database by id.
     * @param id Integer id value.
     * @return WorldDTO object.
     */
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

    /**
     * Saves provided WorldDTO as new world record in database.
     * @param worldInfo WorldDTO object to be saved.
     * @return WorldDTO retrieved from database.
     */
    public WorldDTO saveWorld(WorldDTO worldInfo) {
        World newWorld = new World(
                worldInfo.userName(),
                worldInfo.worldName(),
                worldInfo.dateCreated(),
                worldInfo.worldDesc());

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
