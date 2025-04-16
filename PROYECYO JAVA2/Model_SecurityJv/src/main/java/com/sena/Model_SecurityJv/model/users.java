package com.sena.Model_SecurityJv.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "users")
public class users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "UserName", nullable = false, length = 100)
    private String userName;

    @Column(name = "Active", nullable = false)
    private boolean active;

    @Column(name = "Password", nullable = false, length = 100)
    private String password;

    @Column(name = "IsDeleted", nullable = false)
    private boolean isDeleted;

    @Column(name = "PersonId", nullable = false)
    private int personId;

    // Constructor vacío
    public users() {
    }

    // Constructor completo
    public users(int id, String userName, boolean active, String password, boolean isDeleted, int personId) {
        this.id = id;
        this.userName = userName;
        this.active = active;
        this.password = password;
        this.isDeleted = isDeleted;
        this.personId = personId;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }
}
