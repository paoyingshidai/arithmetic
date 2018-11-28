package com.michael.arithmetic.presort.controller;

import com.michael.arithmetic.presort.entity.Category;
import com.michael.arithmetic.presort.repository.CategoryMapper;
import com.michael.arithmetic.presort.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private CategoryMapper categoryMapper;

    @RequestMapping("add")
    public String add(Category category, Integer type, Long targetCategoryId) {

        if (type == 0) {
            categoryService.addCategoryInSaveLevel(category, targetCategoryId);
        } else if (type == 1) {
            categoryService.addCategoryInSubLevel(category, targetCategoryId);
        }

        return "succcess";
    }

    @RequestMapping("delete")
    public String delete(Long targetCategoryId) {

        categoryService.deleteCategory(targetCategoryId);

        return "delete succcess";
    }


    @RequestMapping("findAll")
    public List<Category> selectAll() {

        return categoryMapper.selectAll();
    }

}
