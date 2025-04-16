package com.sena.Model_SecurityJv.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "roles")
public class roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "Name", nullable = false, length = 100)
    private String name;

    @Column(name = "Code", nullable = false, length = 100)
    private String code;

    @Column(name = "IsDeleted", nullable = false)
    private boolean isDeleted;

    // Relación con la entidad RolUser
    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RolUser> rolUsers = new ArrayList<>();

    // Constructor vacío
    public roles() {
    }

    // Constructor completo
    public roles(int id, String name, String code, boolean isDeleted) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.isDeleted = isDeleted;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public List<RolUser> getRolUsers() {
        return rolUsers;
    }

    public void setRolUsers(List<RolUser> rolUsers) {
        this.rolUsers = rolUsers;
    }
}
