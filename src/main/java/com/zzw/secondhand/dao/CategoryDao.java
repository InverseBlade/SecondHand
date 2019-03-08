package com.zzw.secondhand.dao;

import com.zzw.secondhand.dto.CategoryDTO;
import com.zzw.secondhand.po.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryDao {

    void insertAndGetId(Category category) throws Exception;

    void deleteById(@Param("id") Integer id) throws Exception;

    Category selectById(@Param("id") Integer id) throws Exception;

    void updateSelectiveById(Category category) throws Exception;

    List<Category> listAll() throws Exception;

    List<Category> listIdAndName() throws Exception;

}
