package com.michael.arithmetic.presort.object;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TreeNode<T> implements Serializable {

    private T value;

    private List<TreeNode<T>> children;

}
