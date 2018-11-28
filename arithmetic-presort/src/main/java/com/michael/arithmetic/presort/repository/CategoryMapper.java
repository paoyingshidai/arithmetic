package com.michael.arithmetic.presort.repository;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.michael.arithmetic.presort.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper extends BaseMapper<Category> {

    int save(Category category);

    List<Category> selectAll();

}
