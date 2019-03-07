package com.zzw.secondhand.service.impl;

import com.zzw.secondhand.dao.GoodsDao;
import com.zzw.secondhand.dto.GoodsListFilter;
import com.zzw.secondhand.po.Goods;
import com.zzw.secondhand.service.GoodsService;
import com.zzw.secondhand.util.JsonRes;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsDao goodsDao;

    @Override
    public JsonRes<Goods> findById(Integer id) {
        try {
            Goods goods;
            if ((goods = goodsDao.selectById(id)) == null) {
                return new JsonRes<>(1, "not found");
            }
            return new JsonRes<Goods>(0, "").setData(goods);
        } catch (Exception e) {
            return new JsonRes<>(1, e.getMessage());
        }
    }

    @Override
    public JsonRes<Integer> add(Goods goods) {
        try {
            int id;
            goodsDao.insertAndGetId(goods);
            id = goods.getId();
            return new JsonRes<Integer>(0, "").setData(id);
        } catch (Exception e) {
            return new JsonRes<>(1, e.getMessage());
        }
    }

    @Override
    public JsonRes modifySelectiveById(Goods goods) {
        try {
            goodsDao.updateSelectiveById(goods);
            return new JsonRes(0, "succeed");
        } catch (Exception e) {
            return new JsonRes(1, e.getMessage());
        }
    }

    @Override
    public JsonRes removeById(Integer id) {
        try {
            goodsDao.deleteById(id);
            return new JsonRes(0, "succeed");
        } catch (Exception e) {
            return new JsonRes(1, e.getMessage());
        }
    }

    @Override
    public JsonRes<List<Goods>> listGoods(GoodsListFilter filter, Integer page, Integer limit) {
        return null;
    }

    @Override
    public JsonRes increaseRead(Integer id) {
        return null;
    }

    @Override
    public JsonRes updateStatus(Integer id, String status) {
        return null;
    }

    @Override
    public JsonRes buy(Integer id) {
        return null;
    }

    @Override
    public JsonRes favorite(Integer id) {
        return null;
    }
}
