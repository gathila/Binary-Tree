package com.company;

/**
 * Created by Asus PC on 8/4/2016.
 */
public class BTree<T extends Comparable<T>> {

    private BTreeNode root;

    public BTree(){
        root = null;
    }

    private class BTreeNode<T extends Comparable<T>>{

        private T  value;
        private BTreeNode<T> leftNode;
        private BTreeNode<T> rightNode;

        public BTreeNode(T value){
            this.value = value;
            leftNode = null;
            rightNode = null;
        }
    }

    public void insert(T value){

        BTreeNode<T> newNode = new BTreeNode(value);

        if(root == null){
            root = new BTreeNode(value);
        }
        else{
            BTreeNode<T> node = root;
            while(node != null){
                if (node.value.compareTo(value) <= 0) {
                    if(node.rightNode != null) node = node.rightNode;
                    else{
                        node.rightNode = newNode;
                        return;
                    }
                } else {
                    if(node.leftNode != null) node = node.leftNode;
                    else {
                        node.leftNode = newNode;
                        return;
                    }
                }
            }
        }
    }


    /*
    *   Return rootNode.
    *   Replace the root node with smallest of the right sub tree.
    * */
    public T remove(){
        T removeNode = null;
        BTreeNode<T> node = null;
        BTreeNode<T> tmp = null;

        if(root != null){
            removeNode = (T)root.value;
            if(root.rightNode != null) {
                node = root.rightNode;
                tmp = root;
                if(node.leftNode == null){      // root's nearest right node does not have a left node
                    tmp.value = node.value;
                    if(node.rightNode != null)
                        tmp.rightNode = node.rightNode;
                    else tmp.rightNode = null;
                    return removeNode;
                }
            }
            else {              // Tree only contains root.
                root = null;
                return removeNode;
            }
        }

        while (node != null){
            if(node.leftNode != null){
                tmp = node;
                node = node.leftNode;
            }
            else{
                root.value = node.value;        // node is the left most node of right root's right sub tree
                if(node.rightNode != null){
                    tmp.leftNode = node.rightNode;
                }else{
                    tmp.leftNode = null;
                }
                return removeNode;
            }
        }
        return removeNode;
    }

    public void preOrderTraverse(){
        if(root == null){
            System.out.println("Please add nodes to tree");
            return;
        }
        preOrderTraverse(root);
    }

    private void preOrderTraverse(BTreeNode<T> node){
        System.out.println(node.value);
        if(node.leftNode != null)   preOrderTraverse(node.leftNode);
        if(node.rightNode != null) preOrderTraverse(node.rightNode);
    }
}
