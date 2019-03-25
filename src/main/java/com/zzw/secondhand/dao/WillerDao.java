package com.zzw.secondhand.dao;

import com.zzw.secondhand.dto.WillerListDTO;
import com.zzw.secondhand.po.Willer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WillerDao {

    void insertAndGetId(@Param("userId") Integer userId,
                        @Param("goodsId") Integer goodsId) throws Exception;

    void deleteByGoodsId(@Param("goodsId") Integer goodsId) throws Exception;

    Willer selectByUserIdAndGoodsId(@Param("userId") Integer userId,
                                    @Param("goodsId") Integer goodsId) throws Exception;

    List<WillerListDTO> listWillers(@Param("goodsId") Integer goodsId) throws Exception;

}
