package com.zzw.secondhand.dao;

import com.zzw.secondhand.dto.GoodsListDTO;
import com.zzw.secondhand.dto.GoodsListFilter;
import com.zzw.secondhand.po.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsDao {

    void insertAndGetId(Goods goods) throws Exception;

    void deleteById(@Param("id") Integer id) throws Exception;

    Goods selectById(@Param("id") Integer id) throws Exception;

    void updateSelectiveById(Goods goods) throws Exception;

    void increaseRead(@Param("id") Integer id) throws Exception;

    List<GoodsListDTO> listGoods(@Param("filter") GoodsListFilter filter,
                                 @Param("offset") Integer offset,
                                 @Param("limit") Integer limit) throws Exception;

}
