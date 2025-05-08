package com.sena.Model_SecurityJv.model;

import jakarta.persistence.*;
import java.util.List;

@Entity(name = "form")
public class Form {

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

    @OneToMany(mappedBy = "form", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FormModule> formModule;

    @OneToMany(mappedBy = "form", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RolFormPermission> rolFormPermission;

    public Form() {}

    public Form(int id, String name, String description, boolean isDeleted) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public List<FormModule> getFormModule() {
        return formModule;
    }

    public void setFormModule(List<FormModule> formModule) {
        this.formModule = formModule;
    }

    public List<RolFormPermission> getRolFormPermission() {
        return rolFormPermission;
    }

    public void setRolFormPermission(List<RolFormPermission> rolFormPermission) {
        this.rolFormPermission = rolFormPermission;
    }
}
