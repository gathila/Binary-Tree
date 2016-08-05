package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        BTree<Integer> tree = new BTree<Integer>();
        // 10, 4, 20, 12, 6, 2, 14
        tree.insert(new Integer(10));
        tree.insert(new Integer(4));
        tree.insert(new Integer(20));
        /*tree.insert(new Integer(12));
        tree.insert(new Integer(6));
        tree.insert(new Integer(2));
        tree.insert(new Integer(14));
        tree.insert(new Integer(11));*/

        tree.preOrderTraverse();
        tree.remove();
        System.out.println("\nremove root\n");
        tree.preOrderTraverse();
    }
}
