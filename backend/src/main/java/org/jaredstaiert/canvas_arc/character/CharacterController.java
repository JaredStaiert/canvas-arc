package org.jaredstaiert.canvas_arc.character;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    private final org.jaredstaiert.canvas_arc.character.CharacterService characterService;

    public CharacterController(org.jaredstaiert.canvas_arc.character.CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/all-characters")
    public List<org.jaredstaiert.canvas_arc.character.CharacterSummary> getAllCharacters() {
        return characterService.getAllCharactersById();
    }
}
