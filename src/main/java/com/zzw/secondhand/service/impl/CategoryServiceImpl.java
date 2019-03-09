package com.zzw.secondhand.service.impl;

import com.zzw.secondhand.dao.CategoryDao;
import com.zzw.secondhand.dto.CategoryDTO;
import com.zzw.secondhand.po.Category;
import com.zzw.secondhand.service.CategoryService;
import com.zzw.secondhand.util.JsonRes;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    CategoryDao categoryDao;

    @Override
    public JsonRes<List<CategoryDTO>> list() {
        try {
            List<Category> categories = categoryDao.listIdAndName();
            List<CategoryDTO> categoryDTOS = new ArrayList<>();
            for (Category item : categories) {
                CategoryDTO temp = new CategoryDTO();
                BeanUtils.copyProperties(item, temp);
                categoryDTOS.add(temp);
            }
            return new
                    JsonRes<List<CategoryDTO>>(0, "succeed")
                    .setData(categoryDTOS);
        } catch (Exception e) {
            return new JsonRes<>(1, e.getMessage());
        }
    }

    @Override
    public JsonRes<Integer> add(Category category) {
        try {
            int id;
            categoryDao.insertAndGetId(category);
            id = category.getId();
            return new JsonRes<Integer>(0, "succeed").setData(id);
        } catch (Exception e) {
            return new JsonRes<>(1, e.getMessage());
        }
    }

    @Override
    public JsonRes removeById(Integer id) {
        try {
            categoryDao.deleteById(id);
            return new JsonRes(0, "succeed");
        } catch (Exception e) {
            return new JsonRes(1, e.getMessage());
        }
    }

    @Override
    public JsonRes<Category> findById(Integer id) {
        try {
            return new JsonRes<Category>(0, "succeed")
                    .setData(categoryDao.selectById(id));
        } catch (Exception e) {
            return new JsonRes<>(1, e.getMessage());
        }
    }

    @Override
    public JsonRes modifyById(Category category) {
        try {
            categoryDao.updateSelectiveById(category);
            return new JsonRes(0, "succeed");
        } catch (Exception e) {
            return new JsonRes(1, e.getMessage());
        }
    }
}
