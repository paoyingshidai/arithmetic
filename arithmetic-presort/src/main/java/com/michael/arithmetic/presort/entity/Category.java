package com.michael.arithmetic.presort.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@TableName("t_category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category implements Serializable {

    @TableId("category_id")
    private Integer categoryId;

    @TableField("name")
    private String name;

    @TableField("lft")
    private Integer lft;

    @TableField("rgt")
    private Integer rgt;

}
