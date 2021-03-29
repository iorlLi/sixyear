package ds.serach.tree;

public class Node {
    int value;
    Node leftNode;
    Node rightNode;

    public Node(int value) {
        this.value = value;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public void frontShow() {
        System.out.print(value + " ");
        if (leftNode != null) {
            leftNode.frontShow();
        }
        if (rightNode != null) {
            rightNode.frontShow();
        }
    }

    public Node frontSearch(int i) {
        Node target = null;
        if (this.value == i) {
            return this;
        } else {

            if (leftNode != null) {
                target = leftNode.frontSearch(i);
            }

            if (target != null) {
                return target;
            }
            if (rightNode != null) {
                target = rightNode.frontSearch(i);
            }
        }
        return target;
    }

    public void romove(int i) {
        Node parent = this;
        if (leftNode != null && leftNode.value == i) {
            parent.leftNode = null;
            return;
        }
        if (rightNode != null && rightNode.value == i) {
            parent.rightNode = null;
            return;
        }

        if (this.leftNode != null) {
            parent.leftNode.romove(i);

        }
        if (rightNode != null) {
            parent.rightNode.romove(i);

        }
    }
}
