package org.jaredstaiert.rpg_toolbackend.character;

public interface CharacterSummary {
    Integer getCharacterId();
    String getUserName();
    String getCharacterName();
    Integer getCharacterAge();
    String getCharacterBio();
    String getWorldName();
    String getTimelineName();
}
