package com.zzw.secondhand.service;

import com.zzw.secondhand.dto.*;
import com.zzw.secondhand.po.Goods;
import com.zzw.secondhand.util.JsonRes;

import java.util.List;

public interface GoodsService {

    /**
     * 按条件获取商品列表
     *
     * @param filter GoodsListFilter
     * @param page   int
     * @param limit  int
     * @return JsonRes
     */
    JsonRes<List<GoodsListDTO>> listGoods(GoodsListFilter filter,
                                          Integer page,
                                          Integer limit);

    /**
     * 获取用户卖出的商品
     *
     * @param userId userId
     * @return JsonRes
     */
    JsonRes<List<GoodsListDTO>> listSoldByUserId(Integer userId);

    /**
     * 获得用户买过的商品
     *
     * @param userId userId
     * @return JsonRes
     */
    JsonRes<List<GoodsListDTO>> listBoughtByUserId(Integer userId);

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
     * @param goodsFormDTO Goods
     * @return JsonRes
     */
    JsonRes<Integer> add(GoodsFormDTO goodsFormDTO, Integer userId);

    /**
     * 修改商品部分信息
     *
     * @param goodsFormDTO Goods
     * @return JsonRes
     */
    JsonRes modifySelectiveById(GoodsFormDTO goodsFormDTO);

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
     * @param userId  Buyer
     * @param goodsId goodsId
     * @return JsonRes
     */
    JsonRes buy(Integer userId, Integer goodsId);

    /**
     * 联系卖方
     *
     * @param buyer   买方
     * @param goodsId 商品Id
     * @return JsonRes
     */
    JsonRes<UserBasicDTO> contact(Integer buyer, Integer goodsId);

    /**
     * 获取有意购买者
     *
     * @param goodsId goodsId
     * @return JsonRes
     */
    JsonRes<List<WillerListDTO>> listWillers(Integer goodsId);

}
