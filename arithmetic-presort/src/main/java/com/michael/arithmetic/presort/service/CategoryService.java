package com.michael.arithmetic.presort.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.michael.arithmetic.presort.entity.Category;
import com.michael.arithmetic.presort.object.TreeNode;
import com.michael.arithmetic.presort.repository.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CategoryService extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 添加同级节点
     *
     * 在变更表数据的时候必须要把整个表锁定，不允许有竞争行为，使用悲观锁
     *
     * https://blog.csdn.net/misakaqunianxiatian/article/details/52432071
     * @param category
     * @param id
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addCategoryInSaveLevel(Category category, Long id) {

        // 顶级根
        if (id == -1) {
            Category root = categoryMapper.selectOne(
                    new Category(null, null, 1, null, null, null));
            // 判断是否存在一个根
            if (root == null) {
                category.setLft(1);
                category.setRgt(2);
                category.setParentId(0L);
                category.setLevel(0);
                categoryMapper.save(category);
            } else {
                categoryMapper.rightUp2WhereRightGtRight(root.getRgt());
                categoryMapper.leftUp2WhereLeftGtRight(root.getRgt());

                category.setLft(root.getRgt() + 1);
                category.setRgt(root.getRgt() + 2);

                category.setParentId(0L);
                category.setLevel(0);
                categoryMapper.save(category);
            }

        } else {

            Category c = categoryMapper.selectById(id);

            categoryMapper.rightUp2WhereRightGtRight(c.getRgt());
            categoryMapper.leftUp2WhereLeftGtRight(c.getRgt());

            category.setLft(c.getRgt() + 1);
            category.setRgt(c.getRgt() + 2);

            category.setParentId(c.getParentId());
            category.setLevel(c.getLevel());
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

        category.setParentId(c.getCategoryId());
        category.setLevel(c.getLevel() + 1);
        categoryMapper.save(category);
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteCategory(Long id) {
        Category c = categoryMapper.selectById(id);

        Integer width = c.getRgt() - c.getLft() + 1;

        categoryMapper.deleteWhereLftBetweenLftAndRgt(c.getLft(), c.getRgt());

        categoryMapper.rightSubWidthWhereRightGtRight(width, c.getRgt());
        categoryMapper.leftSubWidthWhereLftGtRight(width, c.getRgt());
    }

    @Override
    public void addCategory(Category category) {
        categoryMapper.save(category);
    }

    /**
     * 这个算法的一个缺点是： 必须保证父节点在前面，因此数据库查询出来时需要排序
     * @return
     */
    @Override
    public List<TreeNode<Category>> findAllCategory() {

        List<Category> categories = categoryMapper.selectAll();

        // 组装
        Long parentId;
        HashMap<Long, TreeNode<Category>> idMapNode = new HashMap<>();
        List<TreeNode<Category>> tree = new ArrayList<>();

        for (Category category : categories) {

            TreeNode<Category> node = new TreeNode<>(category, new ArrayList<>());

            idMapNode.put(category.getCategoryId(), node);

            parentId = category.getParentId();

            if (parentId != null && parentId != 0) {
                if (idMapNode.get(parentId) != null) {
                    idMapNode.get(parentId).getChildren().add(node);
                }
            }

            if (category.getLevel() == 0) {
                tree.add(node);
            }
        }

        return tree;
    }

}
