package com.example.loginandroid_29_09_2023.beans;

public class User {
    private String email;
    private String password; // Puedes agregar otros campos según tus necesidades

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User() {

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

    // Getters y setters
}
