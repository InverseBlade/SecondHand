package com.zzw.secondhand.service;

import com.zzw.secondhand.dto.CategoryDTO;
import com.zzw.secondhand.po.Category;
import com.zzw.secondhand.util.JsonRes;

import java.util.List;

public interface CategoryService {

    /**
     * 获取分类列表
     *
     * @return json
     */
    JsonRes<List<CategoryDTO>> list();

    /**
     * 新增分类
     *
     * @param category 分类
     * @return json
     */
    JsonRes<Integer> add(Category category);

    /**
     * 移除分类
     *
     * @param id Id
     * @return json
     */
    JsonRes removeById(Integer id);

    /**
     * 查找分类
     *
     * @param id Id
     * @return json
     */
    JsonRes<Category> findById(Integer id);

    /**
     * 修改分类
     *
     * @param category Category
     * @return json
     */
    JsonRes modifyById(Category category);

}
