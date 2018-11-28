package com.michael.arithmetic.presort.object;


import lombok.*;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BootstrapTreeNode implements Serializable {

    private static final long serialVersionUID = 6395491475092900669L;

    public Long categoryId;

    public String name;

    public Integer level;

    public Integer lft;

    public Integer rgt;

    public Long parentId;

    public List<BootstrapTreeNode> children;

}