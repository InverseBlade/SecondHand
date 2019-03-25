package com.zzw.secondhand.dto;

public class WillerListDTO {

    private Integer id;

    private String userName;

    private String nickName;

    private String grade;

    public Integer getId() {
        return id;
    }

    public WillerListDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public WillerListDTO setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public WillerListDTO setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public String getGrade() {
        return grade;
    }

    public WillerListDTO setGrade(String grade) {
        this.grade = grade;
        return this;
    }
}
