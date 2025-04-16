package com.sena.Model_SecurityJv.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Column(name = "PersonId", nullable = false)
    private int personId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PersonId", insertable = false, updatable = false)
    private Person person;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RolUser> rolUser = new ArrayList<>();

    // Constructors
    public User() {}

    public User(int id, String userName, boolean active, String password,
                boolean isDeleted, int personId) {
        this.id = id;
        this.userName = userName;
        this.active = active;
        this.password = password;
        this.isDeleted = isDeleted;
        this.personId = personId;
    }

    // Getters & Setters
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

    public static List<User> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    public static Optional<User> findById(int id2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
}
