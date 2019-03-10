package com.zzw.secondhand.service.impl;

import com.zzw.secondhand.dao.FavoriteDao;
import com.zzw.secondhand.dto.GoodsListDTO;
import com.zzw.secondhand.po.Favorite;
import com.zzw.secondhand.service.FavoriteService;
import com.zzw.secondhand.util.JsonRes;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    @Resource
    private FavoriteDao favoriteDao;

    @Override
    public JsonRes<Integer> create(Integer userId, Integer goodsId) {
        try {
            favoriteDao.insert(
                    new Favorite()
                            .setUserId(userId)
                            .setGoodsId(goodsId)
            );
            return new JsonRes<>(0, "succeed");
        } catch (Exception e) {
            return new JsonRes<>(1, e.getMessage());
        }
    }

    @Override
    public JsonRes remove(Integer userId, Integer goodsId) {
        try {
            favoriteDao.deleteByUserIdAndGoodsId(userId, goodsId);
            return new JsonRes(0, "succeed");
        } catch (Exception e) {
            return new JsonRes(1, e.getMessage());
        }
    }

    @Override
    public JsonRes<List<GoodsListDTO>> listGoodsByUserId(Integer userId) {
        try {
            List<GoodsListDTO> goods = favoriteDao.listFavoriteGoodsByUserId(userId);
            return new JsonRes<List<GoodsListDTO>>(0, "succeed")
                    .setData(goods);
        } catch (Exception e) {
            return new JsonRes<>(1, e.getMessage());
        }
    }
}
