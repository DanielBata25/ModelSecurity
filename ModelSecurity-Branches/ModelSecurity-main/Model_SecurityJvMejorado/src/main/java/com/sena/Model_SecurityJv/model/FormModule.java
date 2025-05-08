package com.sena.Model_SecurityJv.model;

import jakarta.persistence.*;

@Entity(name = "form_module")
public class FormModule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "ModuleId", nullable = false)
    private int moduleId;

    @Column(name = "FormId", nullable = false)
    private int formId;

    @Column(name = "IsDeleted", nullable = false)
    private boolean isDeleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ModuleId", insertable = false, updatable = false)
    private Module module;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FormId", insertable = false, updatable = false)
    private Form form;

    public FormModule() {}

    public FormModule(int id, int moduleId, int formId, boolean isDeleted) {
        this.id = id;
        this.moduleId = moduleId;
        this.formId = formId;
        this.isDeleted = isDeleted;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public int getFormId() {
        return formId;
    }

    public void setFormId(int formId) {
        this.formId = formId;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }
}
