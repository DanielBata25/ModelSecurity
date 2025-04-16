package com.sena.Model_SecurityJv.model;

import jakarta.persistence.*;

@Entity(name = "rol_user")
public class RolUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "RolId", nullable = false)
    private int rolId;

    @Column(name = "UserId", nullable = false)
    private int userId;

    @Column(name = "IsDeleted", nullable = false)
    private boolean isDeleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RolId", insertable = false, updatable = false)
    private Rol rol;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId", insertable = false, updatable = false)
    private User user;

    // Constructor vacío
    public RolUser() {}

    // Constructor completo
    public RolUser(int id, int rolId, int userId, boolean isDeleted) {
        this.id = id;
        this.rolId = rolId;
        this.userId = userId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
