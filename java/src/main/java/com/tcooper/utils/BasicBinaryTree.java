package com.tcooper.utils;

import java.awt.*;

public class BasicBinaryTree<T extends Comparable<T>> {

    private TreeNode<T> root;
    private int itemCount = 0;

    public void add(T item) {

        var node = new TreeNode<T>(item);

        // is first?
        if(root == null) {
            root = node;
            itemCount++;
            return;
        }

        //insert sorted
        insertNode(root, node);
    }

    public boolean contains (T item) {
        var node = findNode(root, item);
        return node != null;
    }

    public void remove(T item) {

        var node = findNode(root, item);

        if(node == null){
            throw new IllegalStateException("Node does not exist in tree");
        }

        TreeNode<T> orphan = null;
        // is root?
        if(this.root == node) {

            if(node.getRight() != null) {
                // promote right
                this.root = node.getRight();
                orphan = node.getLeft();
            }
            else if(node.getLeft() != null){
                // promote left
                this.root = node.getLeft();
                orphan = node.getRight();
            }
            else {
                // no children
                this.root = null;
            }
        }
        else {
            // not a root node
            var parent = node.getParent();
            if (parent.getLeft() != null && item.compareTo(parent.getLeft().getData()) == 0) {
                // promote left
                orphan = node.getRight();

                if (node.getLeft() != null) {
                    node.getLeft().setParent(parent);
                }

                parent.setLeft(node.getLeft());

            } else {
                // promote right
                orphan = node.getLeft();

                if (node.getRight() != null) {
                    node.getRight().setParent(parent);
                }

                parent.setRight(node.getRight());
            }
        }

        if(orphan != null) {
            itemCount--;
            insertNode(root, orphan);
        }

        itemCount--;
    }

    public int size(){
        return itemCount;
    }

    private TreeNode<T> findNode(TreeNode<T> parent, T item){

        if(parent == null) {
            throw new IllegalStateException("No data in tree");
        }

        TreeNode<T> next;

        if(item.compareTo(parent.getData()) < 0) {
            // left
            next = parent.getLeft();
        } else if(item.compareTo(parent.getData()) > 0){
            //right
            next = parent.getRight();
        }
        else {
            // found
            return parent;
        }

        if(next == null) return null;
        return findNode(next, item);
    }

    private void insertNode(TreeNode<T> parent, TreeNode<T> child){
        if(child.getData().compareTo(parent.getData()) < 0) {
            // insert left
            if(parent.getLeft() == null) {
                parent.setLeft(child);
                child.setParent(parent);
                itemCount++;
                return;
            }
            else {
                // recurse
                insertNode(parent.getLeft(), child);
            }
        } else if (child.getData().compareTo(parent.getData()) > 0) {
            // insert right
            if(parent.getRight() == null){
                parent.setRight(child);
                child.setParent(parent);
                itemCount++;
            }
            else{
                insertNode(parent.getRight(), child);
            }
        }
    }

}

class TreeNode<T> {

    private TreeNode<T> left;
    private TreeNode<T> right;
    private TreeNode<T> parent;
    private T data;

    public TreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    public TreeNode<T> getParent() {
        return parent;
    }

    public void setParent(TreeNode<T> parent) {
        this.parent = parent;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
