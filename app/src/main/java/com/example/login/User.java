package com.example.login;

public class User {
    private String email;
    private String pwd;
    private String id;
    private String createdAt;
    public User(String email, String pwd, String id, String createdAt) {
        this.email = email;
        this.pwd = pwd;
        this.id = id;
        this.createdAt = createdAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
