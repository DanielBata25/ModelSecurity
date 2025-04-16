package com.sena.Model_SecurityJv.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
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

    @Column(name = "Code", nullable = false, length = 50)
    private String code;

    @Column(name = "IsDeleted", nullable = false)
    private boolean isDeleted;

    @Column(name = "CreateAt", nullable = false)
    private LocalDateTime createAt;

    @Column(name = "DeleteAt")
    private LocalDateTime deleteAt;

    @OneToMany(mappedBy = "rol", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RolUser> rolUser = new ArrayList<>();

    @OneToMany(mappedBy = "rol", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RolFormPermission> rolFormPermission = new ArrayList<>();

    // Constructors
    public Rol() {}
    public Rol(int id, String name, String code, boolean isDeleted, LocalDateTime createAt, LocalDateTime deleteAt) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.isDeleted = isDeleted;
        this.createAt = createAt;
        this.deleteAt = deleteAt;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public boolean isDeleted() { return isDeleted; }
    public void setDeleted(boolean isDeleted) { this.isDeleted = isDeleted; }
    public LocalDateTime getCreateAt() { return createAt; }
    public void setCreateAt(LocalDateTime createAt) { this.createAt = createAt; }
    public LocalDateTime getDeleteAt() { return deleteAt; }
    public void setDeleteAt(LocalDateTime deleteAt) { this.deleteAt = deleteAt; }
    public List<RolUser> getRolUser() { return rolUser; }
    public void setRolUser(List<RolUser> rolUser) { this.rolUser = rolUser; }
    public List<RolFormPermission> getRolFormPermission() { return rolFormPermission; }
    public void setRolFormPermission(List<RolFormPermission> rolFormPermission) { this.rolFormPermission = rolFormPermission; }
}
