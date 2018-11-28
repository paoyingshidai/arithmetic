package com.michael.arithmetic.presort.controller;

import com.michael.arithmetic.presort.entity.Category;
import com.michael.arithmetic.presort.object.BootstrapTreeNode;
import com.michael.arithmetic.presort.object.TreeNode;
import com.michael.arithmetic.presort.repository.CategoryMapper;
import com.michael.arithmetic.presort.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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


    @RequestMapping("findAllTree")
    public List<BootstrapTreeNode> findAllTree() {

        List<TreeNode<Category>> treeNode = categoryService.findAllCategory();

        List<BootstrapTreeNode> bootstrapTreeNodes = new ArrayList<>();

        for (TreeNode<Category> categoryTreeNode : treeNode) {

            bootstrapTreeNodes.add(getNode(categoryTreeNode));
        }

        return bootstrapTreeNodes;
    }


    private BootstrapTreeNode getNode(TreeNode<Category> node) {

        List<BootstrapTreeNode> bootstrapTreeNodes = new ArrayList<>();

        for (TreeNode<Category> child : node.getChildren()) {

            bootstrapTreeNodes.add(getNode(child));
        }

        if (bootstrapTreeNodes.size() == 0) {
            bootstrapTreeNodes = null;
        }

        return new BootstrapTreeNode(
                    node.getValue().getCategoryId(),
                    node.getValue().getName(),
                    node.getValue().getLevel(),
                    node.getValue().getLft(),
                    node.getValue().getRgt(),
                    node.getValue().getParentId(),
                    bootstrapTreeNodes);
    }

}
