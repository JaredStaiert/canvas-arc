package org.jaredstaiert.rpg_toolbackend.character;

import org.jaredstaiert.rpg_toolbackend.user.UserSummary;

public interface CharacterSummary {
    Integer getCharacterId();
    UserSummary getUser();
    String getCharacterName();
    Integer getCharacterAge();
    String getCharacterBio();
}
