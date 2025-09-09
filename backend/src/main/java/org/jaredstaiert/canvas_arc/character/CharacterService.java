package org.jaredstaiert.canvas_arc.character;

import org.jaredstaiert.canvas_arc.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
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
        // Have to sort in service layer because the postgres STRING_AGG can mess with the sorting.
        // Don't sort here if DB returns sorted results or sorting is done in web layer.
        List<CharacterSummary> unsorted = characterRepository.findAllProjectedBy();

        return unsorted.stream()
                .sorted(Comparator.comparingInt(CharacterSummary::getCharacterId))
                .collect(Collectors.toList());
    }

    public List<CharacterSummary> getAllCharactersByUserName(String userName) {
        return characterRepository.findByUserName(userName);
    }

    /**
     * Returns a List of CharacterDTO objects that match provided id's.
     * @param ids Integer[] with 0 or many id's to search for.
     * @return List of length 0 or many with CharacterDTO objects matching id's.
     */
    public List<CharacterDTO> getMultCharacterById(Integer[] ids) {
        List<Character> charList = characterRepository.findAllById(List.of(ids));

        return charList.stream()
                .map(character ->
                        new CharacterDTO(
                                character.getCharacterId(),
                                character.getUserEntity().getUserName(),
                                character.getCharacterName(),
                                character.getCharacterAge(),
                                character.getCharacterBio())
                ).toList();
    }
}
