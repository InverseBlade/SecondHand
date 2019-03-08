package com.zzw.secondhand.dto;

public class UserLoginDTO {

    private String userName;

    private String password;

    private String loginIP;

    public String getUserName() {
        return userName;
    }

    public UserLoginDTO setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getLoginIP() {
        return loginIP;
    }

    public UserLoginDTO setLoginIP(String loginIP) {
        this.loginIP = loginIP;
        return this;
    }
}
