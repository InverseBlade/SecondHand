package com.zzw.secondhand.dto;

import java.sql.Timestamp;

public class GoodsListDTO {

    private Integer id;

    private String name;

    private String desc;

    private Timestamp submitTime;

    private Integer quantity;

    private Float price;

    private Float originPrice;

    private String status;

    private Integer read;

    private String thumbs;

    private String area;

    //所有者的信息
    private Integer sellerId;

    private String nickName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Timestamp getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Timestamp submitTime) {
        this.submitTime = submitTime;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(Float originPrice) {
        this.originPrice = originPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getRead() {
        return read;
    }

    public void setRead(Integer read) {
        this.read = read;
    }

    public String getThumbs() {
        return thumbs;
    }

    public void setThumbs(String thumbs) {
        this.thumbs = thumbs;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
