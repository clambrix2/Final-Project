package com.example.finalproject;

public class User {
    private int userid;
    private String Username;
    private String Password;

    public User()
    {

    }

    public User(int i, String u, String p)
    {
        userid = i;
        Username = u;
        Password = p;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}
