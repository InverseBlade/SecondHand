package com.zzw.secondhand.service;

import com.zzw.secondhand.dto.GoodsListDTO;
import com.zzw.secondhand.util.JsonRes;

import java.util.List;

public interface FavoriteService {

    JsonRes create(Integer userId, Integer goodsId);

    JsonRes remove(Integer userId, Integer goodsId);

    List<GoodsListDTO> listGoodsByUserId(Integer userId);


}
