package com.michael.arithmetic.presort.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.michael.arithmetic.presort.entity.Category;
import com.michael.arithmetic.presort.repository.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 添加同级节点
     * https://blog.csdn.net/misakaqunianxiatian/article/details/52432071
     * @param category
     * @param id
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addCategoryInSaveLevel(Category category, Long id) {

        if (id == -1) {
            Category root = categoryMapper.selectOne(
                    new Category(null, null, 1, null));
            if (root == null) {
                category.setLft(1);
                category.setRgt(2);
                categoryMapper.save(category);
            } else {
                categoryMapper.rightUp2WhereRightGtRight(root.getRgt());
                categoryMapper.leftUp2WhereLeftGtRight(root.getRgt());

                category.setLft(root.getRgt() + 1);
                category.setRgt(root.getRgt() + 2);

                categoryMapper.save(category);
            }

        } else {

            Category c = categoryMapper.selectById(id);

            categoryMapper.rightUp2WhereRightGtRight(c.getRgt());
            categoryMapper.leftUp2WhereLeftGtRight(c.getRgt());

            category.setLft(c.getRgt() + 1);
            category.setRgt(c.getRgt() + 2);

            categoryMapper.save(category);
        }
    }


    /**
     * 添加下级节点
     * @param category
     * @param id
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addCategoryInSubLevel(Category category, Long id) {
        Category c = categoryMapper.selectById(id);

        categoryMapper.rightUp2WhereRightGtLeft(c.getLft());
        categoryMapper.leftUp2WhereLeftGtLeft(c.getLft());

        category.setLft(c.getLft() + 1);
        category.setRgt(c.getLft() + 2);

        categoryMapper.save(category);
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteCategory(Long id) {
        Category c = categoryMapper.selectById(id);

        Integer width = c.getRgt() - c.getLft() + 1;

        categoryMapper.deleteWhereLftBetweenLftAndRgt(c.getLft(), c.getRgt());

        categoryMapper.rightSubWidthWhereRightGtRight(width, c.getRgt());
        categoryMapper.leftSubWidthWhereLftGtRight(width, c.getRgt());;
    }

    @Override
    public void addCategory(Category category) {
        categoryMapper.save(category);
    }
}
