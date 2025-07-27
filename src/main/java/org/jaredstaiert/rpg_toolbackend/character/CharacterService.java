package org.jaredstaiert.rpg_toolbackend.character;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public List<CharacterSummary> getAllCharacters() {
        return characterRepository.findAllProjectedBy();
    }
}
