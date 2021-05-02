package com.oop.study.oopstudy.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MyNode {
    private int data;
    private MyNode left;
    private MyNode right;

    @Builder
    public MyNode(int data) {
        this.data = data;
    }

    public MyNode insertRecursive(final MyNode node, int data) {
        if (node == null) {
            return MyNode.builder().data(data).build();
        }
        if (data < node.data) {
            node.left = insertRecursive(node.left, data);
        } else {
            node.right = insertRecursive(node.right, data);
        }

        return node;
    }

    public MyNode getNodeOrNull(final MyNode node, int data) {
        if (node == null) {
            return null;
        }
        if (node.data == data) {
            return node;
        }
        if (data < node.data) {
            return getNodeOrNull(node.left, data);
        } else {
            return getNodeOrNull(node.right, data);
        }
    }
}
