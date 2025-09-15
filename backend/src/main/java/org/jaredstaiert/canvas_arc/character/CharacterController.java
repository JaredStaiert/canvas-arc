package org.jaredstaiert.canvas_arc.character;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    private final org.jaredstaiert.canvas_arc.character.CharacterService characterService;

    public CharacterController(org.jaredstaiert.canvas_arc.character.CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/all-characters")
    public List<CharacterSummary> getAllCharacters() {
        return characterService.getAllCharactersById();
    }

    @GetMapping("/user")
    public List<CharacterSummary> getCharacterByUserName(@RequestParam String userName) {
        return characterService.getAllCharactersByUserName(userName);
    }

    @GetMapping("/id")
    public ResponseEntity<?> getCharacterById(@RequestParam Integer[] ids) {
        //TODO: Change Integer[] to List<Integer>
        return ResponseEntity.ok(characterService.getMultCharacterById(ids));
    }

    @PutMapping()
    public ResponseEntity<?> updateCharacterById(@RequestBody List<Integer> ids) {

        return null;
    }
}
