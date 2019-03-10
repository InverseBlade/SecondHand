package com.zzw.secondhand.controller;

import com.zzw.secondhand.dto.CategoryDTO;
import com.zzw.secondhand.po.Category;
import com.zzw.secondhand.service.CategoryService;
import com.zzw.secondhand.util.JsonRes;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/category")
public class CategoryController {

    @Resource
    CategoryService categoryService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public JsonRes<Category> detail(@PathVariable("id") Integer id) {
        return categoryService.findById(id);
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public JsonRes<List<CategoryDTO>> list() {
        return categoryService.list();
    }

}
