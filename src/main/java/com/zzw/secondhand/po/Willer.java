package com.zzw.secondhand.po;

import java.sql.Timestamp;

public class Willer {

    private Integer id;

    private Integer userId;

    private Integer goodsId;

    private Timestamp createTime;

    public Integer getId() {
        return id;
    }

    public Willer setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public Willer setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public Willer setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public Willer setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
        return this;
    }
}
