package com.mirceanealcos.confruntarea.entity;

public class User {

    private Long id;
    private String username;
    private String email;
    private String password;
    private String role;
    private Long funds;

    public User() {

    }

    public User(Long id, String username, String email, String password, String role, Long funds) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.funds = funds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getFunds() {
        return funds;
    }

    public void setFunds(Long funds) {
        this.funds = funds;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", funds=" + funds +
                '}';
    }
}
