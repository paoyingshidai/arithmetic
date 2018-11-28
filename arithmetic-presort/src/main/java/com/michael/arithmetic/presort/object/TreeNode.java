package com.michael.arithmetic.presort.object;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class TreeNode<T> implements Serializable {

    private T value;

    private List<TreeNode<T>> children;

}
