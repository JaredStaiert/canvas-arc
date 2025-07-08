package org.jaredstaiert.rpg_toolbackend.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "characters")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "character_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ColumnDefault("'character_name'")
    @Column(name = "character_name", nullable = false, length = Integer.MAX_VALUE)
    private String characterName;

    @ColumnDefault("0")
    @Column(name = "character_age", nullable = false)
    private Short characterAge;

    @ColumnDefault("'character_bio'")
    @Column(name = "character_bio", nullable = false, length = Integer.MAX_VALUE)
    private String characterBio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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