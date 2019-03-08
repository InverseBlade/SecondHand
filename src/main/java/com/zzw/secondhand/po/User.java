package com.zzw.secondhand.po;

public class User {

    private Integer id;

    private String userName;

    private String password;

    private String nickName;

    private String phone;

    private String qq;

    private String weiXin;

    private String college;

    private String area;

    private String grade;

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public User setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getQq() {
        return qq;
    }

    public User setQq(String qq) {
        this.qq = qq;
        return this;
    }

    public String getWeiXin() {
        return weiXin;
    }

    public User setWeiXin(String weiXin) {
        this.weiXin = weiXin;
        return this;
    }

    public String getCollege() {
        return college;
    }

    public User setCollege(String college) {
        this.college = college;
        return this;
    }

    public String getArea() {
        return area;
    }

    public User setArea(String area) {
        this.area = area;
        return this;
    }

    public String getGrade() {
        return grade;
    }

    public User setGrade(String grade) {
        this.grade = grade;
        return this;
    }
}
