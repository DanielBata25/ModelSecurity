package com.sena.Model_SecurityJv.model;

import jakarta.persistence.*;

@Entity(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "FirstName", nullable = false, length = 100)
    private String firstName;

    @Column(name = "LastName", nullable = false, length = 100)
    private String lastName;

    @Column(name = "Email", nullable = false, length = 150)
    private String email;

    @Column(name = "PhoneNumber", length = 20)
    private String phoneNumber;

    @Column(name = "Address", length = 255)
    private String address;

    @Column(name = "IsDeleted", nullable = false)
    private boolean isDeleted;

    @Column(name = "UserId", nullable = false)
    private int userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId", insertable = false, updatable = false)
    private User user;

    // Constructor vacío
    public Person() {
    }

    // Constructor completo
    public Person(int id, String firstName, String lastName, String email,
                  String phoneNumber, String address, boolean isDeleted, int userId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.isDeleted = isDeleted;
        this.userId = userId;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
