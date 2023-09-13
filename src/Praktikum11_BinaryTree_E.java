import java.util.Stack;

public class Praktikum11_BinaryTree_E {
    static class Node {
        int key;
        Node left, right;

        public Node(int data) {
            key = data;
            right = left = null;
        }
    }
    Node root;
    Praktikum11_BinaryTree_E() {
        root = null;
    }

    void PrintPreorder(Node node) {
        if(node == null) {
            return;
        }
        System.out.print(node.key + " ");
        PrintPreorder(node.left);
        PrintPreorder(node.right);
    }
    void PrintPreorder() {
        PrintPreorder(root);
    }

    void PrintInorder(Node node) {
        if(node == null) {
            return;
        }
        PrintInorder(node.left);
        System.out.print(node.key + " ");
        PrintInorder(node.right);
    }
    void PrintInorder() {
        PrintInorder(root);
    }

    void PrintPostorder(Node node) {
        if(node == null) {
            return;
        }
        PrintPostorder(node.left);
        PrintPostorder(node.right);
        System.out.print(node.key + " ");
    }
    void PrintPostorder() {
        PrintPostorder(root);
    }

    // Traversal Non-Recursive
    void inorder() {
        if(root == null) {
            return;
        }
        Stack<Node> s = new Stack<Node>();
        Node curr = root;

        while (curr != null || s.size() > 0) {
            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            System.out.print(curr.key + " ");
            curr = curr.right;
        }
    }

    public static void main(String[] args) {
        Praktikum11_BinaryTree_E tree = new Praktikum11_BinaryTree_E();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(10);
        tree.root.right.left = new Node(20);
        tree.root.right.right = new Node(30);

//        System.out.println("Pre Order Traversal Binary Tree:");
//        tree.PrintPreorder();

        System.out.println("\nIn Order Traversal Binary Tree:");
        tree.PrintInorder();

//        System.out.println("\nPost Order Traversal Binary Tree:");
//        tree.PrintPostorder();

        System.out.println("\nIn Order non Recursive: ");
        tree.inorder();
    }
}
