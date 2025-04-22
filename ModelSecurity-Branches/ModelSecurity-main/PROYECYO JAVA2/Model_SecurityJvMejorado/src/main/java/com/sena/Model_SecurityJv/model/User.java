package com.sena.Model_SecurityJv.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "UserName", nullable = false, length = 100)
    private String userName;

    @Column(name = "Active", nullable = false)
    private boolean active;

    @Column(name = "Password", nullable = false, length = 255)
    private String password;

    @Column(name = "IsDeleted", nullable = false)
    private boolean isDeleted;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PersonId", nullable = false, unique = true)
    private Person person;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RolUser> rolUser = new ArrayList<>();

    // Constructor vacío
    public User() {}

    // Constructor completo
    public User(int id, String userName, boolean active, String password, boolean isDeleted, Person person) {
        this.id = id;
        this.userName = userName;
        this.active = active;
        this.password = password;
        this.isDeleted = isDeleted;
        this.person = person;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<RolUser> getRolUser() {
        return rolUser;
    }

    public void setRolUser(List<RolUser> rolUser) {
        this.rolUser = rolUser;
    }
}
