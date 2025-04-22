package com.sena.Model_SecurityJv.model;

import jakarta.persistence.*;
import java.util.List;

@Entity(name = "module")
public class Module {

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

    @OneToMany(mappedBy = "module", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<FormModule> formModules;

    public Module() {}

    public Module(int id, String name, String description, boolean isDeleted) {
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

    public List<FormModule> getFormModules() {
        return formModules;
    }

    public void setFormModules(List<FormModule> formModules) {
        this.formModules = formModules;
    }
}
