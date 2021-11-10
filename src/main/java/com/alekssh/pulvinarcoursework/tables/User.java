package com.alekssh.pulvinarcoursework.tables;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsers", nullable = false)
    private Integer id;

    @Column(name = "name", length = 70)
    private String name;

    @Column(name = "lastname", length = 70)
    private String lastname;

    @Column(name = "email", length = 70)
    private String email;

    @Column(name = "telephone", length = 25)
    private String telephone;

    @Column(name = "login", nullable = false, length = 70)
    private String login;

    @Column(name = "password", nullable = false, length = 70)
    private String password;

    @Column(name = "role", length = 70)
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}