package com.michael.arithmetic.presort.service;

import com.michael.arithmetic.presort.entity.Category;

public interface ICategoryService {

    void addCategory(Category category);

    void addCategoryInSaveLevel(Category category, Long id);

    void addCategoryInSubLevel(Category category, Long id);

    void deleteCategory(Long id);

}
