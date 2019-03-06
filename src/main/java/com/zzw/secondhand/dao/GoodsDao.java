package com.zzw.secondhand.dao;

import com.zzw.secondhand.po.Goods;
import org.apache.ibatis.annotations.Param;

public interface GoodsDao {

    void insertAndGetId(Goods goods) throws Exception;

    void deleteById(@Param("id") Integer id) throws Exception;

    Goods selectById(@Param("id") Integer id) throws Exception;

    void updateSelectiveById(Goods goods) throws Exception;

}
