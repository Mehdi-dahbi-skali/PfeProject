package com.example.login;

public class Notification {
    //String imgUser;
    //int id;
    String username;
    String action;
   // String imgPost;


    public Notification(String username, String action) {
        this.username = username;
        this.action = action;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
