public class Praktikum11_BinaryTree2 {
    static class Node {
        int key;
        Node left, right;

        public Node(int data) {
            key = data;
            left = right = null;
        }
    }
    Node root;
    Praktikum11_BinaryTree2() {
        root = null;
    }

    // Traversal Binary Tree
    void PrintPreorder(Node node) {
        if(node == null) {
            return;
        }
        // NLR
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
        //LNR
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
        //LRN
        PrintPostorder(node.left);
        PrintPostorder(node.right);
        System.out.print(node.key + " ");
    }
    void PrintPostorder() {
        PrintPostorder(root);
    }

    // Menghitung Kedalaman Binary Tree
    int MaxDepth(Node node) {
        if(node == null) {
            return 0;
        } else {
            int lDepth = MaxDepth(node.left);
            int rDepth = MaxDepth(node.right);

            if(lDepth > rDepth) {
                return (lDepth + 1);
            } else {
                return (rDepth + 1);
            }
        }
    }

    public static void main(String[] args) {
        Praktikum11_BinaryTree2 t = new Praktikum11_BinaryTree2();

        t.root = new Node(1);
        t.root.left = new Node(2);
        t.root.right = new Node(3);
        t.root.left.left = new Node(4);
        t.root.left.right = new Node(5);
        t.root.right.left = new Node(6);

//        System.out.println("Preorder traversal binary tree:");
//        t.PrintPreorder();

//        System.out.println("Inorder traversal binary tree:");
//        t.PrintInorder();

//        System.out.println("Postorder traversal binary tree:");
//        t.PrintPostorder();

        System.out.println("Height of Binary Tree: " + t.MaxDepth(t.root));
    }
}
