package ds.serach.tree;

public class MainTest {
    public static void main(String[] args) {
        BinarTree binarTree = new BinarTree();
        Node root = new Node(1);
        binarTree.setRoot(root);

        Node leftNode = new Node(2);
        Node rightNode = new Node(5);
        root.setLeftNode(leftNode);
        root.setRightNode(rightNode);

        leftNode.setLeftNode(new Node(3));
        leftNode.setRightNode(new Node(4));

        rightNode.setLeftNode(new Node(6));
        rightNode.setRightNode(new Node(7));

        binarTree.frontShow();
        System.out.println("---------------------");
        Node frontSearch = binarTree.frontSearch(5);
        System.out.println(frontSearch);

        System.out.println("---------------------");
        binarTree.remove(6);
        binarTree.frontShow();

    }
}
