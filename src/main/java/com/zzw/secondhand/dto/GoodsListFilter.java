package com.zzw.secondhand.dto;

public class GoodsListFilter {

    private String keyWord;

    private Integer categoryId;

    private String area;

    private Integer sellerId;

    private Integer buyerId;

    private String status;

    public String getStatus() {
        return status;
    }

    public GoodsListFilter setStatus(String status) {
        this.status = status;
        return this;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public GoodsListFilter setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
        return this;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public GoodsListFilter setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
        return this;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public GoodsListFilter setKeyWord(String keyWord) {
        this.keyWord = keyWord;
        return this;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public GoodsListFilter setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public String getArea() {
        return area;
    }

    public GoodsListFilter setArea(String area) {
        this.area = area;
        return this;
    }
}
