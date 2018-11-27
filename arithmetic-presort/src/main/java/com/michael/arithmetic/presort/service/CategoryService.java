package com.michael.arithmetic.presort.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.michael.arithmetic.presort.entity.Category;
import com.michael.arithmetic.presort.repository.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public void addCategory(Category category) {

//        baseMapper.insert(category);

        categoryMapper.save(category);
        System.out.println(category.getCategoryId());

    }

}
