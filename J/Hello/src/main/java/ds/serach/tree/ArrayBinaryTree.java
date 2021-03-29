package ds.serach.tree;

/**
 * 顺序存储二叉树
 */
public class ArrayBinaryTree {
    int[] data;

    public ArrayBinaryTree(int[] data) {
        this.data = data;
    }

    public void frontShow() {
        frontShow(0);
    }

    public void frontShow(int i) {
        System.out.println(data[i]);
        //左子树： 2*n + 1
        if (2 * i + 1 < data.length) {
            frontShow(2 * i + 1);
        }
        //右子树： 2*n + 2
        if (2 * i + 2 < data.length) {
            frontShow(2 * i + 2);
        }
    }
}
