package com.zzw.secondhand.service;

import com.zzw.secondhand.dto.GoodsListFilter;
import com.zzw.secondhand.po.Goods;
import com.zzw.secondhand.util.JsonRes;

import java.util.List;
import java.util.Map;

public interface GoodsService {

    /**
     * 按条件获取商品列表
     *
     * @param filter GoodsListFilter
     * @param page   int
     * @param limit  int
     * @return JsonRes
     */
    JsonRes<List<Goods>> listGoods(GoodsListFilter filter,
                                   Integer page,
                                   Integer limit);

    /**
     * 获得商品detail
     *
     * @param id Id
     * @return JsonRes
     */
    JsonRes<Goods> findById(Integer id);

    /**
     * 添加商品
     *
     * @param goods Goods
     * @return JsonRes
     */
    JsonRes<Integer> add(Goods goods);

    /**
     * 修改商品部分信息
     *
     * @param goods Goods
     * @return JsonRes
     */
    JsonRes modifySelectiveById(Goods goods);

    /**
     * 删除商品
     *
     * @param id Id
     * @return JsonRes
     */
    JsonRes removeById(Integer id);

    /**
     * 增加物品浏览量
     *
     * @param id Id
     * @return JsonRes
     */
    JsonRes increaseRead(Integer id);

    /**
     * 更新物品状态
     *
     * @param id     Id
     * @param status Status
     * @return JsonRes
     */
    JsonRes updateStatus(Integer id, String status);

    /**
     * 购买物品
     *
     * @param id      Id
     * @param buyerId buyerId
     * @return JsonRes
     */
    JsonRes buy(Integer id, Integer buyerId);

}
