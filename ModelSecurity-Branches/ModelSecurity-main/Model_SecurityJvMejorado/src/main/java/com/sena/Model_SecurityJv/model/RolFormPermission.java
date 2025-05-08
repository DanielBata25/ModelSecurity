package com.sena.Model_SecurityJv.model;

import jakarta.persistence.*;

@Entity(name = "rol_form_permission")
public class RolFormPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "RolId", nullable = false)
    private int rolId;

    @Column(name = "FormId", nullable = false)
    private int formId;

    @Column(name = "PermissionId", nullable = false)
    private int permissionId;

    @Column(name = "IsDeleted", nullable = false)
    private boolean isDeleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RolId", insertable = false, updatable = false)
    private Rol rol;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FormId", insertable = false, updatable = false)
    private Form form;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PermissionId", insertable = false, updatable = false)
    private Permission permission;

    public RolFormPermission() {}

    public RolFormPermission(int id, int rolId, int formId, int permissionId, boolean isDeleted) {
        this.id = id;
        this.rolId = rolId;
        this.formId = formId;
        this.permissionId = permissionId;
        this.isDeleted = isDeleted;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRolId() {
        return rolId;
    }

    public void setRolId(int rolId) {
        this.rolId = rolId;
    }

    public int getFormId() {
        return formId;
    }

    public void setFormId(int formId) {
        this.formId = formId;
    }

    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
