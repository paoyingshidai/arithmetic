package com.michael.arithmetic.presort.controller;

import com.michael.arithmetic.presort.entity.Category;
import com.michael.arithmetic.presort.repository.CategoryMapper;
import com.michael.arithmetic.presort.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private CategoryMapper categoryMapper;

    @RequestMapping("add")
    public String add() {

        categoryService.addCategory(new Category(null, "食物", 1, 2));

        return "succcess";
    }


    @RequestMapping("selectAll")
    public List<Category> selectAll() {

        return categoryMapper.selectAll();
    }

}
