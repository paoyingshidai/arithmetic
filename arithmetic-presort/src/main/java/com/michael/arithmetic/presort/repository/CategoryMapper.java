package com.michael.arithmetic.presort.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.michael.arithmetic.presort.entity.Category;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper extends BaseMapper<Category> {

    int save(Category category);

    /**
     * rgt 大于  该节点的 rgt 的节点  的 rgt 增加 2
     * @param right 该节点的右节点
     */
    void rightUp2WhereRightGtRight(Integer right);

    /**
     * lft 大于  该节点的 rgt  的节点  的 lft 增加 2
     * @param right 该节点的右节点
     */
    void leftUp2WhereLeftGtRight(Integer right);

    /**
     * rgt 大于  该节点的 lft 的节点  的 rgt 增加 2
     * @param left 该节点的左节点
     */
    void rightUp2WhereRightGtLeft(Integer left);

    /**
     * lft 大于  该节点的 lft  的节点  的 lft 增加 2
     * @param left 该节点的左节点
     */
    void leftUp2WhereLeftGtLeft(Integer left);

    /**
     * rgt 大于  该节点的 rgt 的节点  的 rgt 减少width
     * @param right 该节点的右节点
     */
    void rightSubWidthWhereRightGtRight(@Param("width") Integer width,
                                        @Param("right") Integer right);

    /**
     * lft 大于  该节点的 rgt 的节点  的 lft 减少 width
     * @param right 该节点的右节点
     */
    void leftSubWidthWhereLftGtRight(@Param("width") Integer width,
                                        @Param("right") Integer right);

    /**
     * 删除左节点在祖先节点内的节点
     * @param left
     * @param right
     */
    void deleteWhereLftBetweenLftAndRgt(@Param("left") Integer left,
                                        @Param("right") Integer right);

    List<Category> selectAll();

}
