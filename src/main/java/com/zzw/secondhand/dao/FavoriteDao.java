package com.zzw.secondhand.dao;

import com.zzw.secondhand.dto.GoodsListDTO;
import com.zzw.secondhand.po.Favorite;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FavoriteDao {

    void insert(Favorite favorite) throws Exception;

    void deleteByUserIdAndGoodsId(@Param("userId") Integer userId,
                                  @Param("goodsId") Integer goodsId) throws Exception;

    Favorite selectByUserIdAndGoodsId(@Param("userId") Integer userId,
                                      @Param("goodsId") Integer goodsId) throws Exception;

    List<GoodsListDTO> listFavoriteGoodsByUserId(@Param("userId") Integer userId) throws Exception;
}
