package com.michael.arithmetic.presort.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@TableName("t_category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category extends Model<Category> {

    @TableId(value = "category_id", type = IdType.AUTO)
    private Long categoryId;

    @TableField("name")
    private String name;

    @TableField("lft")
    private Integer lft;

    @TableField("rgt")
    private Integer rgt;

    @TableField("parent_id")
    private Long parentId;

    @TableField("level")
    private Integer level;

    @Override
    protected Serializable pkVal() {
        return this.categoryId;
    }
}
