package org.jaredstaiert.canvas_arc.user;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_name", length = Integer.MAX_VALUE)
    private String userName;

    @Column(name = "email", length = Integer.MAX_VALUE)
    private String email;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}