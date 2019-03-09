package com.zzw.secondhand.po;

import java.sql.Timestamp;

public class Goods {

    private Integer id;

    private String name;

    private String desc;

    private Timestamp submitTime;

    private Timestamp buyTime;

    private Integer quantity;

    private Float price;

    private Float originPrice;

    private Integer buyerId;

    private Integer sellerId;

    private String status;

    private Integer read;

    private String thumbs;

    private String area;

    private Integer categoryId;

    public Integer getId() {
        return id;
    }

    public Goods setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Goods setName(String name) {
        this.name = name;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public Goods setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public Timestamp getSubmitTime() {
        return submitTime;
    }

    public Goods setSubmitTime(Timestamp submitTime) {
        this.submitTime = submitTime;
        return this;
    }

    public Timestamp getBuyTime() {
        return buyTime;
    }

    public Goods setBuyTime(Timestamp buyTime) {
        this.buyTime = buyTime;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Goods setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public Float getPrice() {
        return price;
    }

    public Goods setPrice(Float price) {
        this.price = price;
        return this;
    }

    public Float getOriginPrice() {
        return originPrice;
    }

    public Goods setOriginPrice(Float originPrice) {
        this.originPrice = originPrice;
        return this;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public Goods setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
        return this;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public Goods setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Goods setStatus(String status) {
        this.status = status;
        return this;
    }

    public Integer getRead() {
        return read;
    }

    public Goods setRead(Integer read) {
        this.read = read;
        return this;
    }

    public String getThumbs() {
        return thumbs;
    }

    public Goods setThumbs(String thumbs) {
        this.thumbs = thumbs;
        return this;
    }

    public String getArea() {
        return area;
    }

    public Goods setArea(String area) {
        this.area = area;
        return this;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public Goods setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
        return this;
    }
}
