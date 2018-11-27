package com.michael.arithmetic.presort.service;

import com.michael.arithmetic.presort.entity.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CategoryServiceTest {

    @Autowired
    private ICategoryService categoryService;

    @Test
    public void addCategory() {

        categoryService.addCategory(new Category(null, "食物", 1, 2));

    }
}