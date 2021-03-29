package ds.serach.tree;

public class BinarTree {
    Node root;

    public void setRoot(Node root) {
        this.root = root;
    }

    public void frontShow() {
        if (root == null) {
            return;
        }
        root.frontShow();
    }

    public Node frontSearch(int x) {
        if (root == null) {
            return null;
        }
        return root.frontSearch(x);
    }

    public void remove(int i) {
        if (root.value == i) {
            root = null;
        }
        root.romove(i);
    }
}
