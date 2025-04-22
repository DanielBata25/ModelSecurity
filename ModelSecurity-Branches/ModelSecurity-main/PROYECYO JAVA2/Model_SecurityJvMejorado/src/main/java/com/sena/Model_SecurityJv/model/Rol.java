package com.sena.Model_SecurityJv.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "Name", nullable = false, length = 100)
    private String name;

    @Column(name = "Description", length = 255)
    private String description;

    @Column(name = "IsDeleted", nullable = false)
    private boolean isDeleted;

    @OneToMany(mappedBy = "rol", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RolUser> rolUser = new ArrayList<>();

    @OneToMany(mappedBy = "rol", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RolFormPermission> rolFormPermission = new ArrayList<>();

    // Constructores
    public Rol() {}

    public Rol(int id, String name, String description, boolean isDeleted) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isDeleted = isDeleted;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean isDeleted() { return isDeleted; }
    public void setDeleted(boolean isDeleted) { this.isDeleted = isDeleted; }

    public List<RolUser> getRolUser() { return rolUser; }
    public void setRolUser(List<RolUser> rolUser) { this.rolUser = rolUser; }

    public List<RolFormPermission> getRolFormPermission() { return rolFormPermission; }
    public void setRolFormPermission(List<RolFormPermission> rolFormPermission) { this.rolFormPermission = rolFormPermission; }
}
