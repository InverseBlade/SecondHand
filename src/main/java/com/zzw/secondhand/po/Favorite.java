package com.zzw.secondhand.po;

import java.sql.Timestamp;

public class Favorite {

    private Integer userId;

    private Integer goodsId;

    private Timestamp createTime;

    public Integer getUserId() {
        return userId;
    }

    public Favorite setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public Favorite setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public Favorite setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
        return this;
    }
}
