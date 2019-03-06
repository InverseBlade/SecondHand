package com.zzw.secondhand.service;

import com.zzw.secondhand.po.Goods;
import com.zzw.secondhand.util.JsonRes;

public interface GoodsService {

    JsonRes<Goods> findById(Integer id);

    JsonRes<Integer> add(Goods goods);

    JsonRes modifySelectiveById(Goods goods);

    JsonRes removeById(Integer id);

}
