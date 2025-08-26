package org.jaredstaiert.canvas_arc.character;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.jaredstaiert.canvas_arc.user.User;

@Entity
@Table(name = "characters")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "character_id", nullable = false)
    private Integer characterId;

//    @ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne()
    @JoinColumn(name = "user_name")
    private User userName;

    @ColumnDefault("'character_name'")
    @Column(name = "character_name", nullable = false, length = Integer.MAX_VALUE)
    private String characterName;

    @ColumnDefault("0")
    @Column(name = "character_age", nullable = false)
    private Short characterAge;

    @ColumnDefault("'character_bio'")
    @Column(name = "character_bio", nullable = false, length = Integer.MAX_VALUE)
    private String characterBio;

    public Integer getCharacterId() {
        return characterId;
    }

    public void setCharacterId(Integer id) {
        this.characterId = id;
    }

    public User getUserName() {
        return userName;
    }

    public void setUserName(User user) {
        this.userName = user;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public Short getCharacterAge() {
        return characterAge;
    }

    public void setCharacterAge(Short characterAge) {
        this.characterAge = characterAge;
    }

    public String getCharacterBio() {
        return characterBio;
    }

    public void setCharacterBio(String characterBio) {
        this.characterBio = characterBio;
    }

}