package org.jaredstaiert.canvas_arc.character;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    /**
     * Returns a sorted summary view of all characters
     * @return All characters sorted by characterId
     */
    public List<CharacterSummary> getAllCharactersById() {
        List<CharacterSummary> unsorted = characterRepository.findAllProjectedBy();
        return unsorted.stream().sorted(Comparator.comparingInt(CharacterSummary::getCharacterId))
                .collect(Collectors.toList());
    }
}
