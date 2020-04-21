package com.example.student2;

public class LoginDB {

    String loginid;
    String username;
    String password;

    public LoginDB(){

    }

    public LoginDB(String loginid, String username, String password) {
        this.loginid = loginid;
        this.username = username;
        this.password = password;
    }

    public String getArtistId() {
        return loginid;
    }

    public String getUserName() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
