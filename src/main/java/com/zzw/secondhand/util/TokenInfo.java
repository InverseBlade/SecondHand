package com.zzw.secondhand.util;

import java.util.Date;

public class TokenInfo {

    private Integer uid;

    private String userName;

    private String loginIP;

    private String secret;

    private Date expire;

    private String token;

    public Integer getUid() {
        return uid;
    }

    public TokenInfo setUid(Integer uid) {
        this.uid = uid;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public TokenInfo setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getLoginIP() {
        return loginIP;
    }

    public TokenInfo setLoginIP(String loginIP) {
        this.loginIP = loginIP;
        return this;
    }

    public String getSecret() {
        return secret;
    }

    public TokenInfo setSecret(String secret) {
        this.secret = secret;
        return this;
    }

    public Date getExpire() {
        return expire;
    }

    public TokenInfo setExpire(Date expire) {
        this.expire = expire;
        return this;
    }

    public String getToken() {
        return token;
    }

    public TokenInfo setToken(String token) {
        this.token = token;
        return this;
    }
}
